package com.qf.mytt.admin.web.controller;

import com.qf.mytt.admin.service.BaseTreeService;
import com.qf.mytt.domain.BaseTreeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseTreeController<T extends BaseTreeEntity, S extends BaseTreeService<T>> {
    @Autowired
    protected S service;

    @ModelAttribute
    public T getEntity(String id) {
        T t = null;

        if (id == null || "0".equals(id)) {
            try {
                ParameterizedType ptype = (ParameterizedType) this.getClass().getGenericSuperclass();
                Class clazz = (Class<T>) ptype.getActualTypeArguments()[0];
                t = (T) clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            t = service.get(Long.parseLong(id));
        }

        return t;
    }

    /**
     * 跳转列表页
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public abstract String list(T t, Model model);

    /**
     * 跳转表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public abstract String form(T t);

    /**
     * 保存
     *
     * @param t
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public abstract String save(T t, Model model, RedirectAttributes redirectAttributes);

    /**
     * 删除
     *
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public abstract String delete(long... ids);

    @ResponseBody
    @RequestMapping(value = "treeData", method = RequestMethod.GET)
    public List<T> treeData(Long id) {
        List<T> tree = service.selectByPid(id == null ? 0L : id);
        return tree;
    }

    protected void sortTree(long parentId, List<T> targetList) {
        List<T> list = service.selectByPid(parentId);
        for (T t : list) {
            targetList.add(t);
            if (t.isParent()) {
                sortTree(t.getId(), targetList);
            }
        }
    }
}
