package com.qf.mytt.admin.service;


import com.qf.mytt.domain.TbUser;

import java.util.List;

public interface UserService extends BaseService<TbUser>{
    List<TbUser> checkUser(TbUser tbUser);

}
