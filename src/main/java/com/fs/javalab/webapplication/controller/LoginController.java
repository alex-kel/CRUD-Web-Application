package com.fs.javalab.webapplication.controller;

import com.fs.javalab.webapplication.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserDAO userDAO;

    private final static String LOGIN_PAGE = "login";
    private final static String LOGIN_ERROR_PAGE = "login_error";
    private final static String PROFILE_PAGE = "profile";

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginView(ModelMap model) {
        return LOGIN_PAGE;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        if (userDAO.getUser(login, password) == null) {
            return LOGIN_ERROR_PAGE;
        }
        return PROFILE_PAGE;
    }
}
