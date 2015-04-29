package com.fs.javalab.webapplication.dao.impl;

import com.fs.javalab.webapplication.dao.UserDAO;
import com.fs.javalab.webapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public class UserDAOImpl implements UserDAO{
    private static final String SELECT_USER_BY_LOGIN_AND_PASSWORD = "SELECT USERID, UserName, Password, FirstName, LastName " +
            "FROM Users u WHERE u.UserName = ? AND u.Password = ?";
    private static final String SELECT_USER_BY_LOGIN = "SELECT USERID, UserName, Password, FirstName, LastName " +
            "FROM Users u WHERE u.UserName = ? AND u.USERID <> ?";
    private static final String UPDATE_USER = "UPDATE Users u " +
            "SET u.UserName = ?, " +
            "u.Password = ?, " +
            "u.FirstName = ?, " +
            "u.LastName = ?" +
            "WHERE u.USERID = ?";
    private static final String DELETE_USER = "DELETE FROM Users u WHERE u.Username = ?";

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUser(String login, String password) {
        return jdbcTemplate.query(SELECT_USER_BY_LOGIN_AND_PASSWORD, new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt(1));
                    user.setLogin(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    user.setFirstName(resultSet.getString(4));
                    user.setLastName(resultSet.getString(5));
                    return user;
                }
                return null;
            }
        });
    }

    @Override
    public void updateUser(User user) throws TimeoutException {

    }

    @Override
    public void deleteUser(User user) throws TimeoutException {

    }

    @Override
    public boolean isExist(User user) throws TimeoutException {
        return false;
    }
}
