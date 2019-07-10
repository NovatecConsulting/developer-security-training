package com.validator;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserPasswordGenerator {

  private final PasswordGenerator generator;
  private final List<CharacterRule> rules;

  public UserPasswordGenerator() {
    rules = Arrays.asList(
            // at least one upper-case character
            new CharacterRule(EnglishCharacterData.UpperCase, 1),

            // at least one lower-case character
            new CharacterRule(EnglishCharacterData.LowerCase, 1),

            // at least one digit character
            new CharacterRule(EnglishCharacterData.Digit, 1));

    generator = new PasswordGenerator();
  }

  public String generatePassword() {
    return generator.generatePassword(12, rules);
  }

}
