package com.validator;

import com.dao.UserDAO;
import com.model.UserAccount;
import com.model.UserAccountForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.passay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class UserAccountValidator implements Validator {

    @Autowired
    private UserDAO userDAO;

    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == UserAccountForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserAccountForm userAccountForm = (UserAccountForm) target;
        String emailInput = userAccountForm.getEmail();
        String userNameInput = userAccountForm.getUserName();
        String passwordInput = userAccountForm.getPassword();
        String confirmPasswordInput = userAccountForm.getRepeatPassword();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.userAccountForm.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userAccountForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatPassword", "NotEmpty.userAccountForm.repeatPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userAccountForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.userAccountForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.userAccountForm.lastName");

        if (!this.emailValidator.isValid(emailInput) && !emailInput.trim().equals("")) {
            errors.rejectValue("email", "Pattern.userAccountForm.email");
        } else if (userAccountForm.getUserId() == null) {
            UserAccount userAccount = userDAO.getUserByEmail(emailInput);
            if (userAccount != null) {
                errors.rejectValue("email", "Duplicate.userAccountForm.email");
            }
        }

        if (!errors.hasFieldErrors("userName")) {
            UserAccount dbUser = userDAO.getUserByUserName(userNameInput);
            if (dbUser != null) {
                // Username is not available.
                errors.rejectValue("userName", "Duplicate.userAccountForm.userName");
            }
        }

        if (!errors.hasFieldErrors("password")) {
            if (!isPasswordValid(passwordInput, errors)) {
                String[] test = new String[2];
                test[0] = ("de");
                test[1] = ("de");
            }
        }

        if (!errors.hasErrors()) {
            if (!confirmPasswordInput.equals(passwordInput)) {
                errors.rejectValue("repeatPassword", "Match.userAccountForm.repeatPassword");
            }
        }
    }

    private boolean isPasswordValid(final String password, Errors errors) {
        final PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new UppercaseCharacterRule(1),
                new DigitCharacterRule(1),
                new SpecialCharacterRule(1)));
        final RuleResult result = validator.validate(new PasswordData(password));
        for (int i = 0; i < result.getDetails().size(); i++) {
            errors.rejectValue("password", result.getDetails().get(i).getErrorCode());
        }
        if (result.isValid()) {
            return true;
        }
        return false;
    }
}