package com.qf.mytt.api.service.test;


import com.qf.mytt.api.service.TbCommentService;
import com.qf.mytt.domain.TbComment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbCommentServoceTest {
    @Autowired
    private TbCommentService tbCommentService;

    @Test
    public void selectContentByTitle(){
        List<TbComment> tbComments = tbCommentService.selectCommentByContentId(1l);
    }

}
