package test;

import com.qf.mytt.admin.service.CommentService;
import com.qf.mytt.domain.TbComment;
import com.qf.mytt.domain.TbContent;
import com.qf.mytt.domain.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbCommentServiceTest {

    @Autowired
    private CommentService tbCommentService;


    @Test
    public void testSelectAll() {
        tbCommentService.selectAll();
    }

    @Test
    public void selectPageList() {
        TbComment tbComment = new TbComment();
        tbComment.setStart(0);
        tbComment.setLength(5);
        tbCommentService.selectPageList(tbComment);
    }


    @Test
    public void getTotalCount() {
        TbComment tbComment = new TbComment();
        tbCommentService.getTotalCount(tbComment);
    }


        @Test
    public void testinsert() {
            TbComment tbComment = new TbComment();
            tbComment.setComContent("123");
            tbComment.setPraiseNum(12);
            tbComment.setStatus(1);

            TbUser tbUser = new TbUser();
            tbUser.setId(1l);
            tbUser.setUsername("mmx");
            tbComment.setTbUser(tbUser);
            TbContent tbContent = new TbContent();
            tbContent.setId(1l);
            tbContent.setTitle("国防。。");

            tbComment.setCreated(new Date());
            tbComment.setUpdated(new Date());
            tbComment.setTbContent(tbContent);
            tbCommentService.insert(tbComment);
    }

    @Test
    public void getByid() {
        tbCommentService.getById(2l);
    }

    @Test
    public void update() {
        TbComment tbComment = tbCommentService.getById(2l);
        tbComment.setComContent("123");
        tbComment.setPraiseNum(13);
        tbCommentService.update(tbComment);
    }

    @Test
    public void delete() {
        tbCommentService.delete(3l);
    }


}
