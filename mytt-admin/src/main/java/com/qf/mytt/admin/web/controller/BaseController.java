package com.qf.mytt.admin.web.controller;


import com.qf.mytt.admin.service.BaseService;
import com.qf.mytt.admin.web.result.DataTablesResult;
import com.qf.mytt.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;

public abstract class BaseController<T extends BaseEntity,S extends BaseService<T>> {

    @Autowired
    protected  S service;
    /**
     * 数据分页展示
     *
     * @param t
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "data", method = RequestMethod.GET)
    public DataTablesResult<T> data(T t, HttpServletRequest request) {
        String strDraw = request.getParameter("draw");

        int draw = Integer.parseInt(strDraw == null ? "0" : strDraw);

        int totalCount = service.getTotalCount(t);
        DataTablesResult dataTablesResult = new DataTablesResult();
        dataTablesResult.setDraw(draw);
        dataTablesResult.setRecordsTotal(totalCount);
        dataTablesResult.setRecordsFiltered(totalCount);
        dataTablesResult.setData(service.selectPageList(t));
        return dataTablesResult;
    }

    @ModelAttribute
    public T get(String id) {
        T t = null;
        if (id == null || "0".equals(id)) {
            try {
                ParameterizedType ptype = (ParameterizedType) this.getClass().getGenericSuperclass();
                Class clazz = (Class<T>) ptype.getActualTypeArguments()[0];
                t = (T) clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
           t=service.getById(Long.parseLong(id));
        }
        return t;
    }


    /**
     * 用户列表跳转
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public abstract String list();


    /**
     * 跳转表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public abstract String form();

    /**
     * 新增与修改表单数据
     *
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public abstract String save(T t, RedirectAttributes redirectAttributes);

    /**
     * 返回用户个人信息页面
     *
     * @param
     * @returnc
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public abstract String detail();

    /**
     * 用户数据删除
     *
     * @param
     * @return
     */
    @RequestMapping(value = "del", method = RequestMethod.GET)
    public abstract String delete(long... ids);

}
