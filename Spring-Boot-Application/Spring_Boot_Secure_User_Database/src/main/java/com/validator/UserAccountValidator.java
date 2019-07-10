package com.validator;

import com.dao.UserRepository;
import com.model.UserAccount;
import com.model.UserAccountForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.passay.CharacterRule;
import org.passay.DictionaryRule;
import org.passay.DictionarySubstringRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.passay.dictionary.ArrayWordList;
import org.passay.dictionary.FileWordList;
import org.passay.dictionary.WordList;
import org.passay.dictionary.WordListDictionary;
import org.passay.dictionary.WordLists;
import org.passay.dictionary.sort.ArraysSort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

@Component
public class UserAccountValidator implements Validator {

    private final UserRepository userRepository;

    private final EmailValidator emailValidator = EmailValidator.getInstance();

    private PasswordValidator passwordValidator;

    public UserAccountValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initPasswordValidator() {
        WordList wordList;
        try {
            wordList = WordLists.createFromReader(
                    new FileReader[] {new FileReader(new ClassPathResource("password-list.txt").getFile())},
                    false,
                    new ArraysSort());
        } catch (IOException ex) {
            wordList = new ArrayWordList(
                    new String[] {"password", "Password", "123456", "12345678", "admin", "geheim", "secret"},
                    false, new ArraysSort());
        }
        passwordValidator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new WhitespaceRule(),
                new DictionaryRule(new WordListDictionary(wordList))));
    }

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
            isPasswordValid(passwordInput, errors);
        }

        if (!errors.hasErrors()) {
            if (!confirmPasswordInput.equals(passwordInput)) {
                errors.rejectValue("repeatPassword", "Match.userAccountForm.repeatPassword");
            }
        }
    }

    private void isPasswordValid(final String password, Errors errors) {
        final RuleResult result = passwordValidator.validate(new PasswordData(password));
        for (int i = 0; i < result.getDetails().size(); i++) {
            errors.rejectValue("password", result.getDetails().get(i).getErrorCode());
        }
    }
}