package com.qf.mytt.admin.dao;


import com.qf.mytt.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao extends BaseDao<TbUser>{
    TbUser getByEmail(String email);
    List<TbUser> checkUser(TbUser tbUser);
}
