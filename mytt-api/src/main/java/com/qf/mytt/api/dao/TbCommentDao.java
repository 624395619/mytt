package com.qf.mytt.api.dao;

import com.qf.mytt.domain.TbComment;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TbCommentDao {
   List<TbComment> selectCommentByContentId(long id);

    List<TbComment> selectCommentByUserId(long id);

}
