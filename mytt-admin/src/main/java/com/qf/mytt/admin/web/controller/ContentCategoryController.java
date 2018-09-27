package com.qf.mytt.admin.web.controller;


import com.qf.mytt.admin.service.ContentCategoryService;
import com.qf.mytt.admin.utils.SystemConstants;
import com.qf.mytt.common.BeanValidator;
import com.qf.mytt.common.validatorInterface.InsertValidate;
import com.qf.mytt.common.validatorInterface.UpdateValidate;
import com.qf.mytt.domain.TbContentCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "category")
public class ContentCategoryController extends BaseTreeController<TbContentCategory, ContentCategoryService> {

    /**
     * 内容分类跳转
     *
     * @return
     */
    @Override
    public String list(TbContentCategory tbContentCategory, Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        sortTree(0L, targetList);
        model.addAttribute("list", targetList);
        return SystemConstants.VIEW_CATEGORY_LIST;
    }

    /**
     * 返回内容分类信息
     *
     * @return
     */
    @Override
    public String form(TbContentCategory tbContentCategory) {
        return SystemConstants.VIEW_CATEGORY_FORM;
    }

    @Override
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes) {
        //内容分类数据长度格式校验
        //校验信息
        String validatorMSG = null;
        //新增操作校验
        if (tbContentCategory.getId() == 0) {
            validatorMSG = BeanValidator.validator(tbContentCategory, InsertValidate.class);
        }

        //修改操作校验
        else {
            validatorMSG = BeanValidator.validator(tbContentCategory, UpdateValidate.class);
        }

        //验证不通过
        if (validatorMSG != null) {
            redirectAttributes.addFlashAttribute("category", tbContentCategory);
            redirectAttributes.addFlashAttribute(SystemConstants.TIPS_MESSAGE, validatorMSG);
            return SystemConstants.REDIRECT_CATEGORY_FORM;
        }

        //验证通过
        else {
            tbContentCategory.setStatus(1);
            service.save(tbContentCategory);
            redirectAttributes.addFlashAttribute(SystemConstants.TIPS_MESSAGE, "保存内容信息成功");
            return SystemConstants.REDIRECT_CATEGORY_LIST;
        }
    }

    @Override
    public String delete(long... ids) {
        if (ids.length == 1) {
            service.delete(ids[0]);
        }
        return  SystemConstants.REDIRECT_CATEGORY_LIST;
    }
}
