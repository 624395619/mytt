package com.qf.mytt.api.controller.v1;

import com.qf.mytt.api.service.TbCommentService;
import com.qf.mytt.common.dto.BaseResult;
import com.qf.mytt.domain.TbComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/comments")
public class CommentController {

    @Autowired
    private TbCommentService tbCommentService;

    /**
     * 通过 内容 id 获取 该内容下 所有的评论
     * @param id
     * @return
     */
    @GetMapping(value = "contentallcomment")
    public BaseResult selectCommentByContentId(long id){
        List<TbComment> tbComments = tbCommentService.selectCommentByContentId(id);
            if (tbComments != null && tbComments.size() != 0){
                return BaseResult.success(tbComments);
            }
        return BaseResult.fail();
    }

    /**
     * 通过 用户的id 获取 用户的所有的评论
     * @param id
     * @return
     */
    @GetMapping(value = "userallcomment")
    public BaseResult selectCommentByUserId(long id){
        List<TbComment> tbComments = tbCommentService.selectCommentByUserId(id);
        if (tbComments != null && tbComments.size() != 0){
            return BaseResult.success(tbComments);
        }
        return BaseResult.fail();
    }
}
