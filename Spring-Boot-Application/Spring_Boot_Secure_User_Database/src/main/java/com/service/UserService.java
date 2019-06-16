package com.service;

import com.dao.UserDAO;
import com.dao.UserRepository;
import com.model.UserAccount;
import com.model.UserAccountForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDAO userDAO;

    public void saveUser(UserAccount user) {
        userRepository.save(user);
    }

    public List<UserAccount> getAllUsersByUserName() {
        return userDAO.getAllUsersByUserName();
    }

    public UserAccount getUserByUsername(String searchTerm) {
        return userDAO.getUserByUserName(searchTerm);
    }

    public UserAccount createUser(UserAccountForm userAccountForm) {
        return userDAO.createUser(userAccountForm);
    }
}
