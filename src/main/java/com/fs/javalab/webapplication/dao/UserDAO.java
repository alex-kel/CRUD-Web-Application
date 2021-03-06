package com.fs.javalab.webapplication.dao;

import com.fs.javalab.webapplication.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.util.concurrent.TimeoutException;

public interface UserDAO {

    public User getUser(String login, String password) throws TimeoutException;

    public void updateUser(User user) throws TimeoutException;

    public void deleteUser(User user) throws TimeoutException;

    public boolean isExist(User user) throws TimeoutException;
}
