package com.qf.mytt.api.service;

import com.qf.mytt.domain.TbComment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TbCommentService {

    List<TbComment> selectCommentByContentId(long id);

    List<TbComment> selectCommentByUserId(long id);
}
