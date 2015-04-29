package com.fs.javalab.webapplication.configuration;

import com.fs.javalab.webapplication.dao.UserDAO;
import com.fs.javalab.webapplication.dao.impl.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.fs.javalab.webapplication")
public class DAOConfiguration {

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }
}
