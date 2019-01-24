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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAccountValidator userAccountValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public MainController(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
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

    @PostConstruct
    public void setUserAccounts() {
        UserDetails u1 = User.withUsername("admin").password(passwordEncoder.encode("$ecUr€84")).roles("ADMIN").build();
        UserDetails u2 = User.withUsername("standarduser").password(passwordEncoder.encode("$ecUr€84")).roles("USER").build();
        inMemoryUserDetailsManager.createUser(u1);
        inMemoryUserDetailsManager.createUser(u2);

        List<UserAccount> userAccountList = userService.getAllUsersByUserName();
        for (int i = 2; i < userAccountList.size(); i++) {
            inMemoryUserDetailsManager.createUser(User
                    .withUsername(userAccountList.get(i).getUserName())
                    .password(userAccountList.get(i).getEncrytedPassword())
                    .roles(userAccountList.get(i).getUserRole())
                    .build());
        }
    }

    @RequestMapping("/")
    public String viewHome(Model model) {

        return "home";
    }

    @RequestMapping(value = "/usersearch", method = RequestMethod.GET)
    public String search(@RequestParam(value = "searchInput", required = false) String searchTerm, Model model) {
        UserAccount userAccount = userService.getUserByUsername(searchTerm);

        model.addAttribute("searchInput", userAccount);
        return "userSearch";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        User user = (User) ((Authentication) principal).getPrincipal();
        UserAccount userAccount = userService.getUserByUsername(user.getUsername());

        model.addAttribute("userInfo", userAccount);

        return "userInfo";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        User user = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(user);
        model.addAttribute("userInfo", userInfo);

        List<UserAccount> list = userService.getAllUsersByUserName();
        model.addAttribute("userAccountList", list);

        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "login";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessful(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessful";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegister(Model model) {
        UserAccountForm form = new UserAccountForm();

        model.addAttribute("userAccountForm", form);

        return "registration";
    }

    @RequestMapping("/registrationSuccessful")
    public String viewRegistrationSuccessful(Model model) {
        return "registrationSuccessful";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
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

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveRegister(Model model,
                               @ModelAttribute("userAccountForm") @Validated UserAccountForm userAccountForm, //
                               BindingResult result, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "registration";
        }

        UserAccount newUser = null;

        try {
            newUser = userService.createUser(userAccountForm);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "registration";
        }

        redirectAttributes.addFlashAttribute("flashUser", newUser);

        userService.saveUser(newUser);

        UserDetails u1 = User.withUsername(newUser.getUserName()).password(newUser.getEncrytedPassword()).roles("USER").build();
        inMemoryUserDetailsManager.createUser(u1);

        return "redirect:/registrationSuccessful";
    }

    @RequestMapping(value = "/api/useraccounts", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<UserAccount> getUserAccounts() {
        return userService.getAllUsersByUserName();
    }
}