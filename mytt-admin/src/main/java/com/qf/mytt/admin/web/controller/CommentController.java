package com.qf.mytt.admin.web.controller;



import com.qf.mytt.admin.service.CommentService;
import com.qf.mytt.admin.utils.SystemConstants;
import com.qf.mytt.common.BeanValidator;
import com.qf.mytt.common.validatorInterface.InsertValidate;
import com.qf.mytt.common.validatorInterface.UpdateValidate;
import com.qf.mytt.domain.TbComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "comment")
public class CommentController extends BaseController<TbComment, CommentService> {

    @Autowired
    private CommentService commentService;

    /**
     * 内容列表跳转
     *
     * @return
     */

    public String list() {
        return SystemConstants.VIEW_COMMENT_LIST;
    }

    @Override
    public String form() {
        return SystemConstants.VIEW_COMMENT_FORM;
    }

    @Override
    public String save(TbComment tbComment, RedirectAttributes redirectAttributes) {
        //内容数据长度格式校验
        //校验信息
        String validatorMSG = null;
        //新增操作校验
        if (tbComment.getId() == 0) {
            validatorMSG = BeanValidator.validator(tbComment, InsertValidate.class);
        }

        //修改操作校验
        else {
            validatorMSG = BeanValidator.validator(tbComment, UpdateValidate.class);
        }

        //验证不通过
        if (validatorMSG != null) {
            redirectAttributes.addFlashAttribute("tbComment", tbComment);
            redirectAttributes.addFlashAttribute(SystemConstants.TIPS_MESSAGE, validatorMSG);
            return SystemConstants.REDIRECT_COMMENT_FORM;
        }

        //验证通过
        else {
            commentService.save(tbComment);
            redirectAttributes.addFlashAttribute(SystemConstants.TIPS_MESSAGE, "保存内容信息成功");
            return SystemConstants.REDIRECT_COMMENT_LIST;
        }
    }

    @Override
    public String detail() {
        return SystemConstants.VIEW_COMMENT_DETAIL;
    }

    @Override
    public String delete(long[] ids) {

        //删除单个用户信息
        if (ids.length == 1) {
            commentService.delete(ids[0]);
        }

        //删除多个用户信息
        else {
            commentService.deleteAll(ids);
        }
        return SystemConstants.VIEW_COMMENT_LIST;
    }

}
