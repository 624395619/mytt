package com.qf.mytt.api.controller.v1;

import com.qf.mytt.api.dto.TbContentDTO;
import com.qf.mytt.api.service.TbContentService;
import com.qf.mytt.common.dto.BaseResult;
import com.qf.mytt.domain.TbContent;
import com.qf.mytt.domain.TbContentCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.qf.mytt.api.utils.ContentControllerUtils.filterUnnecessaryProperty;
import static com.qf.mytt.api.utils.ContentControllerUtils.getContentCopytoDto;

@RestController
@RequestMapping(value = "v1/contents")
public class ContentController {

    @Autowired
    private TbContentService tbContentService;

    /**
     * 通过分类的id获取 该分类的所有内容信息
     *
     * @return
     */
    @RequestMapping(value = "categorycontent", method = RequestMethod.GET)
    public BaseResult getContentByCategoryId(long id) {
        List<TbContent> list = tbContentService.selectContentByCategoryId(id);

        if (list.size() != 0 && list != null) {
            getContentCopytoDto(list);
            return BaseResult.success(list);
        }
        return BaseResult.fail();
    }

    /**
     * 热点 轮播图
     *
     * @return
     */
    @RequestMapping(value = "ppt", method = RequestMethod.GET)
    public BaseResult ppt() {
        List<TbContent> list = tbContentService.selectContentByCategoryId(100l);
        getContentCopytoDto(list);
        return BaseResult.success(list);
    }

    /**
     * 根据内容 id 获取内容信息
     *
     * @return
     */
    @RequestMapping(value = "content", method = RequestMethod.GET)
    public BaseResult getContentById(long id) {

        TbContent tbContent = tbContentService.get(id);
        if (tbContent != null) {
            TbContentDTO dto = new TbContentDTO();
            BeanUtils.copyProperties(tbContent, dto);
            filterUnnecessaryProperty(dto, tbContent);
            return BaseResult.success(dto);

        }
        return BaseResult.fail("不存在id");
    }

    /**
     * 通过关键字 获取相应的内容
     */
    @GetMapping(value = "/{tagInfo}")
    public BaseResult getContentBytagInfo(@PathVariable("tagInfo") String tagInfo) {

        TbContent tbContent = new TbContent();
        tbContent.setTagInfo(tagInfo);
        List<TbContent> list = tbContentService.selectContentBytagInfo(tbContent);
        if(list != null && list.size() !=0){
            getContentCopytoDto(list);

            return BaseResult.success(list);
        }
        return  BaseResult.fail();
    }

    /**
     * 通过作者id 获取相应的内容
     */
    @GetMapping(value = "authorcontent")
    public BaseResult getContentByAuthorId(long id) {
        List<TbContent> list = tbContentService.selectContentByAuthorId(id);

        if (list != null && list.size() != 0) {
            return BaseResult.success(list);
        }
        return BaseResult.fail("不存在id");
    }

    /**
     * 通过标题 获取相应的内容
     */
    @GetMapping(value = "/{title}")
    public BaseResult getContentByTitle(String title) {
        TbContent tbContent = new TbContent();
        tbContent.setTitle(title);
        List<TbContent> list = tbContentService.selectContentByTitle(tbContent);
        if (list != null && list.size() != 0) {
            return BaseResult.success(list);
        }
        return BaseResult.fail("不存在标题");
    }
}
