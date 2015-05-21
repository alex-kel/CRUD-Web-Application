package com.fs.javalab.webapplication.service.impl;

import com.fs.javalab.webapplication.dao.UserDAO;
import com.fs.javalab.webapplication.model.User;
import com.fs.javalab.webapplication.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDao;

    public User getUserByNameAndPassword(String login, String password) throws TimeoutException {
        return userDao.getUser(login, password);
    }

    public void deleteUser(User user) throws TimeoutException {
        userDao.deleteUser(user);
    }

    public void updateUser(User user) throws TimeoutException {
        userDao.updateUser(user);
    }

    public boolean isExist(User user) throws TimeoutException {
        return userDao.isExist(user);
    }
}
