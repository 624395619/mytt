package com.qf.mytt.api.service.Impl;

import com.qf.mytt.api.dao.TbCommentDao;
import com.qf.mytt.api.service.TbCommentService;
import com.qf.mytt.domain.TbComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbCommentServiceImpl implements TbCommentService{

    @Autowired
    private TbCommentDao tbCommentDao;

    @Override
    public List<TbComment> selectCommentByContentId(long id) {
        return tbCommentDao.selectCommentByContentId(id);
    }

    @Override
    public List<TbComment> selectCommentByUserId(long id) {
        return tbCommentDao.selectCommentByUserId(id);
    }
}
