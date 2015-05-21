package com.fs.javalab.webapplication.controller;

import com.fs.javalab.webapplication.dao.UserDAO;
import com.fs.javalab.webapplication.model.User;
import com.fs.javalab.webapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    private final static String LOGIN_PAGE = "login";
    private final static String LOGIN_ERROR_PAGE = "login_error";
    private final static String CONNECTION_ERROR_PAGE = "connection_error";

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginView(ModelMap model) {
        return LOGIN_PAGE;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        User user = null;
        try {
            user = userService.getUserByNameAndPassword(login, password);
        } catch (TimeoutException e) {
            return CONNECTION_ERROR_PAGE;
        }
        if (user == null) {
            return LOGIN_ERROR_PAGE;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "redirect:/profile";
    }
}
