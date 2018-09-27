package com.qf.mytt.admin.web.controller;


import com.qf.mytt.admin.service.MainService;
import com.qf.mytt.admin.utils.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController{

    @Autowired
    private MainService mainService;

    @RequestMapping(value = SystemConstants.STRING_MAIN, method = RequestMethod.GET)
    public String toMain() {
        return SystemConstants.STRING_MAIN;
    }


}
