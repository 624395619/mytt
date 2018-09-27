package com.qf.mytt.api.service;

import com.qf.mytt.domain.TbContent;

import java.util.List;

public interface TbContentService {
    TbContent get(long id);

    List<TbContent> selectContentByCategoryId(long id);

    List<TbContent>  selectContentBytagInfo(TbContent tbContent);

    List<TbContent>  selectContentByAuthorId(long id);

    List<TbContent> selectContentByTitle(TbContent  tbContent);

}
