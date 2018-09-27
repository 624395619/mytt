package com.qf.mytt.api.controller.ch;

import com.qf.mytt.api.dto.TbContentDTO;
import com.qf.mytt.api.service.CategoryService;
import com.qf.mytt.api.service.TbContentService;
import com.qf.mytt.common.dto.BaseResult;
import com.qf.mytt.domain.TbContent;
import com.qf.mytt.domain.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.qf.mytt.api.utils.ContentControllerUtils.getContentCopytoDto;

@RestController
@RequestMapping(value = "/ch")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TbContentService tbContentService;

    /**
     * 通过地址名 获取其分类的信息
     *
     * @param address
     * @return
     */
    @GetMapping(value = "categoryInfo")
    public BaseResult getCategory(String address) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setAddress(address);
        TbContentCategory tbContentCategory1 = categoryService.getByAddress(tbContentCategory);
        System.out.println(tbContentCategory1.getId());
        List<TbContent> list = tbContentService.selectContentByCategoryId(tbContentCategory1.getId());
        if (list != null && list.size() != 0) {
            getContentCopytoDto(list);
            return BaseResult.success(list);
        }
        return BaseResult.fail("没有该分类的内容");
    }
}
