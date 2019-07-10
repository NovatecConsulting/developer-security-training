package com.service;

import com.dao.UserRepository;
import com.model.UserAccount;
import com.model.UserAccountForm;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void saveUser(UserAccount user) {
        userRepository.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    public UserAccount getUserByUsername(String searchTerm) {
        return userRepository.findOneByUserName(searchTerm);
    }

    @PreAuthorize("isFullyAuthenticated()")
    public UserAccount getUserByUsernameIgnoreCase(String searchTerm) {
        return userRepository.findOneByUserNameIgnoreCase(searchTerm);
    }

    @Transactional
    public UserAccount createUser(UserAccountForm userAccountForm) {
        UUID userId = UUID.randomUUID();
        String encryptedPassword = this.passwordEncoder.encode(userAccountForm.getPassword());
        UserAccount user = new UserAccount(userId, userAccountForm.getUserName(), userAccountForm.getFirstName(), userAccountForm.getLastName(),
                "USER", userAccountForm.getEmail(), encryptedPassword);
        return userRepository.save(user);
    }
}
