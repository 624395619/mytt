package com.qf.mytt.admin.web.controller;




import com.qf.mytt.admin.service.LoginService;
import com.qf.mytt.admin.utils.SystemConstants;
import com.qf.mytt.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes(SystemConstants.STRING_USER)
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"", SystemConstants.STRING_LOGIN}, method = RequestMethod.GET)
    public String login() {
        return SystemConstants.STRING_LOGIN;
    }

    @RequestMapping(value = SystemConstants.STRING_LOGIN, method = RequestMethod.POST)
    public String login(TbUser user, Model model, HttpServletResponse response) {
        TbUser logUser = loginService.login(user.getEmail(), user.getPassword());
        if (logUser != null) {
            isRemember(user, response);
            model.addAttribute(SystemConstants.STRING_USER, logUser);
            return "redirect:/main";
        } else {
            if (user.getEmail() != null) {
                model.addAttribute(SystemConstants.TIPS_MESSAGE, "用户名或密码错误");
                model.addAttribute(SystemConstants.STRING_USER, user);
            }
            return SystemConstants.STRING_LOGIN;
        }
    }


    private void isRemember(TbUser user, HttpServletResponse response) {
        if (user.getRemember() != null) {
            Cookie cookie = new Cookie(SystemConstants.STRING_REMEMBER, user.getEmail());
            if (user.getAutoLogin() != null) {
                cookie = new Cookie(SystemConstants.STRING_REMEMBER, user.getEmail() + "_autoLogin");
            }
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
        }
    }
}
