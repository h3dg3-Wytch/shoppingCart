package com.h3dg3wytch.models;

import java.util.UUID;

/**
 * Created by h3dg3wytch on 12/3/16.
 */
public class User {


    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;


    public User(){
        this.userId = UUID.randomUUID().toString();
    }

    public User(String firstName, String lastName,String userName,String password){
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public User(String userId, String firstName, String lastName,String userName,String password){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return " FirstName: " + firstName+  " LastName:" + lastName + " UserName " + userName+ " UserID: " + userId +" Password: " + password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
