package com.qf.mytt.api.service.Impl;

import com.qf.mytt.api.dao.TbContentDao;
import com.qf.mytt.api.service.TbContentService;
import com.qf.mytt.domain.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbContentServiceImpl implements TbContentService {
  @Autowired
  private TbContentDao tbContentDao;
    @Override
    public TbContent get(long id) {
        return tbContentDao.get(id);
    }

    @Override
    public List<TbContent> selectContentByCategoryId(long id) {
        return tbContentDao.selectContentByCategoryId(id);
    }

    @Override
    public List<TbContent> selectContentBytagInfo(TbContent tbContent) {
        return tbContentDao.selectContentBytagInfo(tbContent);
    }

    @Override
    public List<TbContent> selectContentByAuthorId(long id) {
        return tbContentDao.selectContentByAuthorId(id);
    }

    @Override
    public List<TbContent> selectContentByTitle(TbContent tbContent) {
        return tbContentDao.selectContentByTitle(tbContent);
    }
}
