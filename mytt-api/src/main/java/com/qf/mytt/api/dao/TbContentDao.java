package com.qf.mytt.api.dao;

import com.qf.mytt.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentDao {

    TbContent get(long id);

    List<TbContent> selectContentByCategoryId(long id);

    List<TbContent>  selectContentBytagInfo(TbContent tbContent);

    List<TbContent>  selectContentByAuthorId(long  id);

    List<TbContent> selectContentByTitle(TbContent  tbContent);
}
