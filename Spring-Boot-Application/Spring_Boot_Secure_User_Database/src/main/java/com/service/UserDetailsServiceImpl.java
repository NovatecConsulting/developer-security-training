package com.service;

import com.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserAccount user = this.userService.getUserByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("UserAccount " + userName + " was not found in the database");
        }

        return User.withUsername(user.getUserName()).password(user.getEncrytedPassword()).roles(user.getUserRole()).build();
    }
}

