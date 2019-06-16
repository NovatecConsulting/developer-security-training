package com.dao;

import com.model.UserAccount;
import com.model.UserAccountForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDAO {

    private static final String SQL_GET_USER_BY_USER_NAME = "SELECT user FROM " + UserAccount.class.getName() + " user " //
            + " WHERE user.userName = :userName ";
    private static final String SQL_GET_ALL_USERS_BY_USER_NAME = "SELECT user FROM " + UserAccount.class.getName() + " user ";
    private static final String SQL_GET_USER_BY_EMAIL = "SELECT user FROM " + UserAccount.class.getName() + " user " //
            + " WHERE user.email = :email ";

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private List<UserAccount> list = new ArrayList<>();

    public UserAccount getUserByUserName(String userName) {
        try {
            Query query = entityManager.createQuery(SQL_GET_USER_BY_USER_NAME, UserAccount.class);
            query.setParameter("userName", userName);

            return (UserAccount) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<UserAccount> getAllUsersByUserName() {
        Query query = entityManager.createQuery(SQL_GET_ALL_USERS_BY_USER_NAME, UserAccount.class);
        list = query.getResultList();
        return list;
    }

    public UserAccount createUser(UserAccountForm form) {
        Long userId = this.getMaxUserId() + 1;
        String encrytedPassword = this.passwordEncoder.encode(form.getPassword());
        UserAccount user = new UserAccount(userId, form.getUserName(), form.getFirstName(), form.getLastName(),
                "USER", form.getEmail(), encrytedPassword);
        list.add(user);
        return user;
    }

    public UserAccount getUserByEmail(String email) {
        try {
            Query query = entityManager.createQuery(SQL_GET_USER_BY_EMAIL, UserAccount.class);
            query.setParameter("email", email);

            return (UserAccount) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Long getMaxUserId() {
        Long maxUserId = Long.valueOf(list.size());
        return maxUserId;
    }
}