package com.validator;

import com.dao.UserRepository;
import com.model.UserAccount;
import com.model.UserAccountForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.passay.*;
import org.passay.dictionary.ArrayWordList;
import org.passay.dictionary.WordListDictionary;
import org.passay.dictionary.sort.ArraysSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class UserAccountValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

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
            UserAccount userAccount = userRepository.findOneByEmail(emailInput);
            if (userAccount != null) {
                errors.rejectValue("email", "Duplicate.userAccountForm.email");
            }
        }

        if (!errors.hasFieldErrors("userName")) {
            UserAccount dbUser = userRepository.findOneByUserNameIgnoreCase(userNameInput);
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
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new WhitespaceRule(),
                new DictionaryRule(new WordListDictionary(new ArrayWordList(
                        new String[] {"password", "Password", "123456", "12345678", "admin", "geheim", "secret"},
                        false, new ArraysSort())))));
        final RuleResult result = validator.validate(new PasswordData(password));
        for (int i = 0; i < result.getDetails().size(); i++) {
            errors.rejectValue("password", result.getDetails().get(i).getErrorCode());
        }
        return result.isValid();
    }
}