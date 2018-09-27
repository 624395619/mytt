package com.qf.mytt.admin.web.controller;



import com.qf.mytt.admin.service.UserService;
import com.qf.mytt.admin.utils.SystemConstants;
import com.qf.mytt.common.BeanValidator;
import com.qf.mytt.common.validatorInterface.InsertValidate;
import com.qf.mytt.common.validatorInterface.UpdateValidate;
import com.qf.mytt.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = SystemConstants.STRING_USER)
public class UserController extends BaseController<TbUser, UserService>{

    @Autowired
    private UserService userService;

    /**
     * 用户列表跳转
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return SystemConstants.VIEW_USER_LIST;
    }

    /**
     * 跳转表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return SystemConstants.VIEW_USER_FORM;
    }

    /**
     * 新增与修改表单数据
     *
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, RedirectAttributes redirectAttributes) {
        //用户数据长度格式校验
        //校验信息
        String validatorMSG = null;
        //新增操作校验
        if (tbUser.getId() == 0) {
            validatorMSG = BeanValidator.validator(tbUser, InsertValidate.class);
        }

        //修改操作校验
        else {
            validatorMSG = BeanValidator.validator(tbUser, UpdateValidate.class);
        }

        //验证不通过
        if (validatorMSG != null) {
            redirectAttributes.addFlashAttribute("tbUser", tbUser);
            redirectAttributes.addFlashAttribute(SystemConstants.TIPS_MESSAGE, validatorMSG);
            return SystemConstants.REDIRECT_USER_FORM;
        }

        //验证通过
        else {

            //用户信息唯一性校验
            List<TbUser> list = userService.checkUser(tbUser);
            if (list.size() > 0) {
                //错误信息判断拼装
                String ErronMSG = getErronMSG(list,tbUser);
                redirectAttributes.addFlashAttribute("tbUser", tbUser);
                redirectAttributes.addFlashAttribute(SystemConstants.TIPS_MESSAGE, ErronMSG);
                return SystemConstants.REDIRECT_USER_FORM;
            }
            userService.save(tbUser);
            redirectAttributes.addFlashAttribute(SystemConstants.TIPS_MESSAGE, "保存用户信息成功");
            return SystemConstants.REDIRECT_USER_LIST;
        }
    }


    /**
     * 返回用户个人信息页面
     *
     * @param
     * @returnc
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "modules/user/detail";
    }

    /**
     * 用户数据删除
     *
     * @param
     * @return
     */
    @RequestMapping(value = "del", method = RequestMethod.GET)
    public String delete(long[] ids) {

        //删除单个用户信息
        if (ids.length == 1) {
            userService.delete(ids[0]);
        }

        //删除多个用户信息
        else {
            userService.deleteAll(ids);
        }
        return SystemConstants.REDIRECT_USER_LIST;
    }

    /**
     * 错误信息判断提取拼装
     * @param list
     * @param tbUser
     * @return
     */
    private String getErronMSG(List<TbUser> list, TbUser tbUser) {
        StringBuffer sb = new StringBuffer();
        String str = "数据验证失败:<br/>";
        int i = 0;
        for(TbUser u : list){
            if(u.getUsername().equals(tbUser.getUsername())||!str.contains("1")){
                str +="1";
            }
            if(u.getPhone().equals(tbUser.getPhone())||!str.contains("2")){
                str +="2";
            }
            if(u.getEmail().equals(tbUser.getEmail())||!str.contains("3")){
                str +="3";
            }
            if(str.contains("1")
                    && str.contains("2")
                    && str.contains("3")){
                break;
            }
        }
        if(str.contains("1")){
            sb.append((++i)+".用户名已存在<br/>");
        }
        if(str.contains("2")){
            sb.append((++i)+".此号码已被使用<br/>");
        }
        if(str.contains("3")){
            sb.append((++i)+".此邮箱已被使用<br/>");
        }
        return sb.toString();
    }

}
