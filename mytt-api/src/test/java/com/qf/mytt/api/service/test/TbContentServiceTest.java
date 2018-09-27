package com.qf.mytt.api.service.test;


import com.qf.mytt.api.dto.TbContentDTO;
import com.qf.mytt.api.service.TbContentService;
import com.qf.mytt.common.dto.BaseResult;
import com.qf.mytt.domain.TbContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbContentServiceTest {


    @Autowired
    private TbContentService tbContentService;

    @Test
    public void testGet(){
        TbContent tbContent = tbContentService.get(1l);
        System.out.println(tbContent.getTitle());
    }

    @Test
    public void selectContentByCategoryId(){
        List<TbContentDTO> list = new ArrayList<>();
        List<TbContent> ppt = tbContentService.selectContentByCategoryId(2l);
        for (TbContent tbContent : ppt) {
            TbContentDTO dto = new TbContentDTO();
            BeanUtils.copyProperties(tbContent, dto);
            list.add(dto);
        }
    }


    @Test
    public void getContentById(){

        TbContent tbContent = tbContentService.get(1l);

        TbContentDTO dto = new TbContentDTO();
        BeanUtils.copyProperties(tbContent, dto);


         BaseResult.success(dto);
    }


    /**
     * 通过关键字 获取相应的内容
     */
    @Test
    public void getContentBytagInfo() {
        TbContent tbContent = new TbContent();
        tbContent.setTagInfo("sb");
        List<TbContent> list = tbContentService.selectContentBytagInfo(tbContent);
    }

    /**
     * 通过作者id 获取 所有的文章内容
     */
    @Test
    public void getContentByAuthorId() {
        List<TbContent> list = tbContentService.selectContentByAuthorId(1l);
    }




}
