package com.qf.mytt.admin.service.impl;


import com.qf.mytt.admin.dao.TbUserDao;
import com.qf.mytt.admin.service.LoginService;
import com.qf.mytt.common.CookieUtils;
import com.qf.mytt.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl extends BaseServiceImpl<TbUser, TbUserDao> implements LoginService {

    @Autowired
    private TbUserDao tbUserDao;

    public TbUser login(String email, String password) {
        TbUser user = tbUserDao.getByEmail(email);
        if (checkPassword(user, password)) return user;
        return null;
    }

    private boolean checkPassword(TbUser user, String password) {
        if (user==null)return false;

        if (user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))
                ||user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public TbUser autoLogin(HttpServletRequest request) {
        String cookieValue = CookieUtils.getCookieValue(request, "remember");
        TbUser user = null;
        if (cookieValue != null) {
            String[] cookieArr = cookieValue.split("_");
            if (cookieArr.length >= 1) {
                user = tbUserDao.getByEmail(cookieArr[0]);
                user.setRemember("remember");
                if (cookieArr.length > 1) {
                    user.setAutoLogin("autoLogin");
                }

            }

        }
        return user;
    }

}
