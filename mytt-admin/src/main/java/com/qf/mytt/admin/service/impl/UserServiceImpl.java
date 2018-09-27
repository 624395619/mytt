package com.qf.mytt.admin.service.impl;


import com.qf.mytt.admin.dao.TbUserDao;
import com.qf.mytt.admin.service.UserService;
import com.qf.mytt.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<TbUser, TbUserDao> implements UserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    @Transactional(readOnly = false)
    public void update(TbUser user) {
        user.setUpdated(new Date());
        tbUserDao.update(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void insert(TbUser user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setCreated(new Date());
        user.setUpdated(new Date());
        tbUserDao.insert(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(TbUser tbUser) {
        if(tbUser.getId()==0){
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
            tbUser.setCreated(new Date());
            tbUser.setUpdated(new Date());
            tbUserDao.insert(tbUser);
        }

        else{
            tbUser.setUpdated(new Date());
            tbUserDao.update(tbUser);
        }
    }

    @Override
    public List<TbUser> checkUser(TbUser tbUser) {
        return tbUserDao.checkUser(tbUser);
    }
}
