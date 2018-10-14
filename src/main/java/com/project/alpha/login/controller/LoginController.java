package com.project.alpha.login.controller;

import com.project.alpha.account.model.AccountModel;
import com.project.alpha.account.service.AccountDetailService;
import com.project.alpha.system.model.ResultAndMsgModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final AccountDetailService accountDetailService;

    @Autowired
    public LoginController(AccountDetailService accountDetailService) {
        this.accountDetailService = accountDetailService;
    }

    @GetMapping(value = "/login")
    public ModelAndView loginPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("/login");
        return model;
    }

    @GetMapping(value = "/login/join")
    public ModelAndView joinPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("/login/join");
        return model;
    }

    @PostMapping(value = "/login/join")
    public String joinProcess(AccountModel accountModel, HttpServletRequest request, RedirectAttributes redirectAttributes){
        ResultAndMsgModel result = new ResultAndMsgModel(true, "계정생성이 완료되었습니다.");
        String redirectURL = "/login";
        try {
            accountDetailService.insertAccountInfo(accountModel);
        } catch (Exception e){
            result.setResult(false);
            result.setMsg("계정생성이 실패하였습니다.");
            redirectURL = request.getHeader("referer");
            LOGGER.error("error", e);
        }
        redirectAttributes.addFlashAttribute(result);
        return "redirect:" + redirectURL;
    }

    @RequestMapping(value = "/")
    public String test(){
        return "index";
    }

}
