package com.model;

import org.owasp.encoder.Encode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.spec.EncodedKeySpec;
import java.util.UUID;

@Entity
public class UserAccount extends AbstractPersistable<Long> {

    @NotNull
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
    private String encryptedPassword;

    @SuppressWarnings("unused")
    public UserAccount() {

    }

    public UserAccount(UUID userId, String userName, String firstName, String lastName, //
                       String userRole, String email, String encryptedPassword) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return Encode.forHtml(userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return Encode.forHtml(firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return Encode.forHtml(lastName);
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
        return Encode.forHtml(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}