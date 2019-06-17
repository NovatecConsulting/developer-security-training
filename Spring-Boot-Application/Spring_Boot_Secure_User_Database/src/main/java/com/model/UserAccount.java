package com.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class UserAccount extends AbstractPersistable<Long> {

    private UUID userId;

    @NotNull
    @Size(min = 1, max = 36)
    private String userName;

    @NotNull
    @Size(min = 1, max = 36)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 36)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 36)
    private String userRole;

    @NotNull
    @Email
    @Size(min = 1, max = 36)
    private String email;

    @NotNull
    @Size(min = 1, max = 128)
    private String encrytedPassword;

    public UserAccount() {

    }

    public UserAccount(UUID userId, String userName, String firstName, String lastName, //
                       String userRole, String email, String encrytedPassword) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
        this.email = email;
        this.encrytedPassword = encrytedPassword;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
}