package com.dao;

import com.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findOneByEmail(String email);
    UserAccount findOneByUserId(UUID userId);
    UserAccount findOneByUserName(String userName);
    UserAccount findOneByUserNameIgnoreCase(String userName);

}