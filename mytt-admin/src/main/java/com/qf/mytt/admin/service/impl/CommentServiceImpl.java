package com.qf.mytt.admin.service.impl;

import com.qf.mytt.admin.dao.TbCommentDao;
import com.qf.mytt.admin.service.CommentService;
import com.qf.mytt.domain.TbComment;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends BaseServiceImpl<TbComment,TbCommentDao> implements CommentService{
}
