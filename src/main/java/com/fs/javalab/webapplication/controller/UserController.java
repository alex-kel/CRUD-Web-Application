package com.fs.javalab.webapplication.controller;

import com.fs.javalab.webapplication.controller.forms.UserForm;
import com.fs.javalab.webapplication.dao.UserDAO;
import com.fs.javalab.webapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeoutException;


@Controller
@RequestMapping("/profile")
public class UserController {

    private final static String PROFILE_PAGE = "profile";
    private final static String LOGIN_PAGE = "login";

    @Autowired
    UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String showUser(ModelMap modelMap,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return LOGIN_PAGE;
        }
        modelMap.addAttribute("user", user);
        return PROFILE_PAGE;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().invalidate();
        try {
            userDAO.deleteUser(user);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(HttpServletRequest request, HttpServletResponse response) {

    }

}