package com.controller;

import com.model.UserAccount;
import com.model.UserAccountForm;
import com.service.UserService;
import com.util.WebUtils;
import com.validator.UserAccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    private final UserAccountValidator userAccountValidator;

    @Autowired
    public UserController(UserService userService,
                          UserAccountValidator userAccountValidator) {
        this.userService = userService;
        this.userAccountValidator = userAccountValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }

        if (target.getClass() == UserAccountForm.class) {
            dataBinder.setValidator(userAccountValidator);
        }
    }

    @GetMapping("/")
    public String viewHome(Model model) {

        return "home";
    }

    @GetMapping(value = "/usersearch")
    public String search(@RequestParam(value = "searchInput", required = false) String searchTerm, Model model) {
        UserAccount userAccount = userService.getUserByUsernameIgnoreCase(searchTerm);

        model.addAttribute("searchInput", userAccount);
        return "userSearch";
    }

    @GetMapping(value = "/userInfo")
    public String userInfo(Model model, Principal principal) {
        User user = (User) ((Authentication) principal).getPrincipal();
        UserAccount userAccount = userService.getUserByUsername(user.getUsername());

        model.addAttribute("userInfo", userAccount);

        return "userInfo";
    }

    @GetMapping(value = "/admin")
    public String adminPage(Model model, Principal principal) {
        User user = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(user);
        model.addAttribute("userInfo", userInfo);

        List<UserAccount> list = userService.getAllUsers();
        model.addAttribute("userAccountList", list);

        return "admin";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {

        return "login";
    }

    @GetMapping(value = "/logoutSuccessful")
    public String logoutSuccessful(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessful";
    }


    @GetMapping(value = "/registration")
    public String viewRegister(Model model) {
        UserAccountForm form = new UserAccountForm();

        model.addAttribute("userAccountForm", form);

        return "registration";
    }

    @GetMapping("/registrationSuccessful")
    public String viewRegistrationSuccessful(Model model) {
        return "registrationSuccessful";
    }

    @GetMapping(value = "/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User user = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(user);

            model.addAttribute("userInfo", userInfo);

            String message = "You are currently logged in as user " + principal.getName() + "." //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }

        return "403Page";
    }

    @PostMapping(value = "/registration")
    public String saveRegister(Model model,
                               @ModelAttribute("userAccountForm") @Validated UserAccountForm userAccountForm, //
                               BindingResult result, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "registration";
        }

        UserAccount newUser;

        try {
            newUser = userService.createUser(userAccountForm);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "registration";
        }

        redirectAttributes.addFlashAttribute("flashUser", newUser);

        userService.saveUser(newUser);

        UserDetails u1 = User.withUsername(newUser.getUserName()).password(newUser.getEncrytedPassword()).roles("USER").build();

        return "redirect:/registrationSuccessful";
    }

    @GetMapping(value = "/api/useraccounts",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<UserAccount> getUserAccounts() {
        return userService.getAllUsers();
    }
}