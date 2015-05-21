package com.fs.javalab.webapplication.service;

import com.fs.javalab.webapplication.model.User;

import java.util.concurrent.TimeoutException;

public interface UserService {

    public User getUserByNameAndPassword(String login, String password) throws TimeoutException;

    public void deleteUser(User user) throws TimeoutException;

    public void updateUser(User user) throws TimeoutException;

    public boolean isExist(User user) throws TimeoutException;
}
