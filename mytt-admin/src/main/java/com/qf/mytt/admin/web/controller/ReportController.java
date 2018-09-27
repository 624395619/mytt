package com.qf.mytt.admin.web.controller;

import com.qf.mytt.admin.service.ReportService;
import com.qf.mytt.admin.utils.SystemConstants;
import com.qf.mytt.common.BeanValidator;
import com.qf.mytt.common.validatorInterface.InsertValidate;
import com.qf.mytt.common.validatorInterface.UpdateValidate;
import com.qf.mytt.domain.TbReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "report")
public class ReportController extends BaseController<TbReport, ReportService> {
    @Autowired
    private ReportService reportService;


    /**
     * 内容列表跳转
     *
     * @return
     */

    public String list() {
        return SystemConstants.VIEW_REPORT_LIST;
    }

    @Override
    public String form() {
        return SystemConstants.VIEW_REPORT_FORM;
    }

    @Override
    public String save(TbReport tbReport, RedirectAttributes redirectAttributes) {
        //内容数据长度格式校验
        //校验信息
        String validatorMSG = null;
        //新增操作校验
        if (tbReport.getId() == 0) {
            validatorMSG = BeanValidator.validator(tbReport, InsertValidate.class);
        }

        //修改操作校验
        else {
            validatorMSG = BeanValidator.validator(tbReport, UpdateValidate.class);
        }

        //验证不通过
        if (validatorMSG != null) {
            redirectAttributes.addFlashAttribute("tbReport", tbReport);
            redirectAttributes.addFlashAttribute(SystemConstants.TIPS_MESSAGE, validatorMSG);
            return SystemConstants.REDIRECT_REPORT_FORM;
        }

        //验证通过
        else {
            reportService.save(tbReport);
            redirectAttributes.addFlashAttribute(SystemConstants.TIPS_MESSAGE, "保存内容信息成功");
            return SystemConstants.REDIRECT_REPORT_LIST;
        }
    }

    @Override
    public String detail() {
        return SystemConstants.VIEW_REPORT_DETAIL;
    }

    @Override
    public String delete(long[] ids) {

        //删除单个用户信息
        if (ids.length == 1) {
            reportService.delete(ids[0]);
        }

        //删除多个用户信息
        else {
            reportService.deleteAll(ids);
        }
        return SystemConstants.VIEW_REPORT_LIST;
    }

}
