package com.util;

import com.dao.UserRepository;
import com.model.UserAccount;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  @Transactional
  public void run(String... args) {
    userRepository.save(
        new UserAccount(
            UUID.randomUUID(),
            "admin",
            "Walter",
            "Root",
            "ADMIN",
            "admin@example.com",
            passwordEncoder.encode("$ecUr€84")));
    userRepository.save(
        new UserAccount(
            UUID.randomUUID(),
            "standarduser",
            "Hans",
            "Mustermann",
            "USER",
            "standard@example.com",
            passwordEncoder.encode("$ecUr€84")));
  }
}
