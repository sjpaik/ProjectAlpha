package com.project.alpha.test.controller;

import com.project.alpha.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/")
    public String test(){
        return "index";
    }

}
