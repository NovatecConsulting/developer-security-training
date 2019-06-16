package com.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_ACCOUNT")
@TableGenerator(name = "tab", initialValue = 2, allocationSize = 1)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "USER_NAME", length = 36, nullable = false)
    private String userName;

    @Column(name = "FIRST_NAME", length = 36, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 36, nullable = false)
    private String lastName;

    @Column(name = "USER_ROLE", length = 36, nullable = false)
    private String userRole;

    @Column(name = "EMAIL", length = 36, nullable = false)
    private String email;

    @Column(name = "ENCRYPTED_PASSWORD", length = 128, nullable = false)
    private String encrytedPassword;

    public UserAccount() {

    }

    public UserAccount(Long userId, String userName, String firstName, String lastName, //
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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