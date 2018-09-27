package test;

import com.qf.mytt.admin.service.ReportService;
import com.qf.mytt.domain.TbComment;
import com.qf.mytt.domain.TbContent;
import com.qf.mytt.domain.TbReport;
import com.qf.mytt.domain.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbReportServiceTest  {

    @Autowired
    private ReportService tbReportService;


    @Test
    public void testSelectAll() {
        tbReportService.selectAll();
    }

    @Test
    public void selectPageList() {
        TbReport tbReport = new TbReport();
        tbReport.setStart(0);
        tbReport.setLength(5);
        tbReportService.selectPageList(tbReport);
    }


    @Test
    public void getTotalCount() {
        TbReport tbReport = new TbReport();
        tbReportService.getTotalCount(tbReport);
    }


    @Test
    public void testinsert() {
        TbReport tbReport = new TbReport();
        tbReport.setIsDeal(1);
        TbUser reporter = new TbUser();
        reporter.setId(1l);
        reporter.setUsername("zs");
        tbReport.setReporter(reporter);

        tbReport.setReportContent("测试评论");

        TbUser toReporter = new TbUser();
        toReporter.setUsername("ls");
        toReporter.setId(2l);

        tbReport.setToReporter(toReporter);

        TbComment tbComment = new TbComment();
        tbComment.setId(1l);
        tbReport.setTbComment(tbComment);
        tbReportService.insert(tbReport);

    }

    @Test
    public void getByid() {
        tbReportService.getById(2l);
    }

    @Test
    public void updateTest() {
        TbReport byId = tbReportService.getById(2);
        byId.setReportContent("sdsd");
        tbReportService.update(byId);
    }


    @Test
    public void delete() {
        tbReportService.delete(2l);
    }



}
