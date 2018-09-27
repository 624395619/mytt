package com.qf.mytt.admin.service;


import com.qf.mytt.domain.TbUser;

import javax.servlet.http.HttpServletRequest;

public interface LoginService extends BaseService<TbUser> {
    TbUser login(String username, String password);
    TbUser autoLogin(HttpServletRequest request);
}
