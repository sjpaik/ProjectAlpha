package com.project.alpha.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public ModelAndView loginPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("/login");
        return model;
    }

    @RequestMapping(value = "/")
    public String test(){
        return "index";
    }

}
