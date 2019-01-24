package com.service;

import com.dao.UserDAO;
import com.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserAccount user = this.userDAO.getUserByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("UserAccount " + userName + " was not found in the database");
        }

        UserDetails userDetails = User.withUsername(user.getUserName()).password(user.getEncrytedPassword()).roles(user.getUserRole()).build();
        return userDetails;
    }
}

