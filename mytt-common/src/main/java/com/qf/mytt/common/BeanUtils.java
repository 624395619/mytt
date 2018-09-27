package com.qf.mytt.common;

import java.lang.reflect.ParameterizedType;

public class BeanUtils<T> {

    public static Object t = null;
    static{
        try {
            ParameterizedType ptype = (ParameterizedType) BeanUtils.class.getGenericSuperclass();
            Class clazz = (Class) ptype.getActualTypeArguments()[0];
            t = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
