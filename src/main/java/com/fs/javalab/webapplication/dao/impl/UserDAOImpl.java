package com.fs.javalab.webapplication.dao.impl;

import com.fs.javalab.webapplication.dao.UserDAO;
import com.fs.javalab.webapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

@Repository
public class UserDAOImpl implements UserDAO {
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

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUser(final String login, final String password) {
        return jdbcTemplate.query(SELECT_USER_BY_LOGIN_AND_PASSWORD,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setString(1, login);
                        preparedStatement.setString(2, password);
                    }
                },
                new ResultSetExtractor<User>() {
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
        jdbcTemplate.update(UPDATE_USER,
                user.getLogin(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword());
    }

    @Override
    public void deleteUser(User user) throws TimeoutException {
        jdbcTemplate.update(DELETE_USER,
                user.getLogin());
    }

    @Override
    public boolean isExist(final User user) throws TimeoutException {
        return jdbcTemplate.query(SELECT_USER_BY_LOGIN,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setString(1, user.getLogin());
                        preparedStatement.setInt(2, user.getId());
                    }
                },
                new ResultSetExtractor<Boolean>() {
                    @Override
                    public Boolean extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        if (resultSet.next()) {
                            return true;
                        }
                        return false;
                    }
                });
    }
}
