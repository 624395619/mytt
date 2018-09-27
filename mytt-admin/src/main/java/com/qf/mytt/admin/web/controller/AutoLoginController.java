package com.qf.mytt.admin.web.controller;


import com.qf.mytt.admin.service.LoginService;
import com.qf.mytt.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AutoLoginController{

    @Autowired
    private LoginService loginService;

    @RequestMapping(value="autoLogin",method = RequestMethod.POST)
    @ResponseBody
    public TbUser autoLogin(HttpServletRequest request){
        TbUser user = loginService.autoLogin(request);
        return user;
    }
}
