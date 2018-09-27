package test;


import com.qf.mytt.admin.service.ContentService;
import com.qf.mytt.domain.TbContent;
import com.qf.mytt.domain.TbContentCategory;
import com.qf.mytt.domain.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbContentServiceTest {
    @Autowired
    private ContentService tbContentService;

    @Test
    public void testSelectAll() {
        tbContentService.selectAll();
    }

    //新增
    @Test
    public void testInsert() {

        TbContent tbContent = new TbContent();
        tbContent.setContent("李尚振是Sb的内容");
        tbContent.setTitle("李尚振是Sb");
        tbContent.setUrl("www.baidu.com");
        tbContent.setTagInfo("SB");
        tbContent.setCoverPic("封面图地址");

        TbUser tbUser = new TbUser();
        tbUser.setId(1l);
        tbUser.setUsername("mmx");
        tbContent.setTbUser(tbUser);

        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(2l);
        tbContentCategory.setName("mmx2");
        tbContent.setTbContentCategory(tbContentCategory);

        tbContentService.insert(tbContent);
    }

    //获取内容信息
    @Test
    public void getById() {
        TbContent tbContent = tbContentService.getById(0l);
        TbUser tbUser = tbContent.getTbUser();
        TbContentCategory tbContentCategory = tbContent.getTbContentCategory();
        System.out.println(  tbContentCategory.getName());
    }

    //修改
    @Test
    public void testUpdate() {
        TbContent tbContent = tbContentService.getById(0l);
        tbContent.setTitle("修改李尚振的狗头");
        tbContentService.update(tbContent);
    }

    //删除
    @Test
    public void testdelete() {
        tbContentService.delete(0l);
    }


    //删除
    @Test
    public void selectPageList() {
        TbContent tbContent = new TbContent();
        tbContent.setStart(0);
        tbContent.setLength(10);
        tbContentService.selectPageList(tbContent);
    }

    @Test
    public void getTotalCount() {
        TbContent tbContent = new TbContent();
        tbContentService.getTotalCount(tbContent);
    }


    @Test
    public void UUid() {
        for (int i = 0; i<201 ;i++){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        System.out.println(uuidStr);
        }
    }
}
