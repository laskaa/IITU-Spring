package com.spring.controllers;

import com.spring.beans.UserBean;
import com.spring.dao.User;
import com.spring.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arman 03.11.17.
 */

@Controller
public class HomeController {
    @Autowired
    UserBean userBean;

    @RequestMapping(value = "/")
    public ModelAndView index(){return new ModelAndView("index");}

    @RequestMapping(value = "/users")
    public ModelAndView users(){
        List<Users> usersArrayList = userBean.getUsersList();
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", usersArrayList);

        return mv;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public void addUser(HttpServletResponse response,
                        @RequestParam(name = "login") String login,
                        @RequestParam(name = "password") String password,
                        @RequestParam(name = "name") String firstName,
                        @RequestParam(name = "surname") String surname
                        ){

        User u = new User(login, password, firstName, surname);
        userBean.AddUser(u);
        try{
            response.sendRedirect("/");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
