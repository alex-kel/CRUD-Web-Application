package com.fs.javalab.webapplication.controller;

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

    private final static String LOGIN_PAGE = "login";
    private final static String LOGIN_ERROR_PAGE = "login_error";

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginView(ModelMap model) {
        return LOGIN_PAGE;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        return LOGIN_ERROR_PAGE;
    }
}
