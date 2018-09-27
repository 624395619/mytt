package com.qf.mytt.api.utils;

import com.qf.mytt.api.dto.TbContentDTO;
import com.qf.mytt.domain.TbContent;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


public class ContentControllerUtils {

    /**
     * 传入一个内容集合 转配 到dto 并且把不需要的信息过滤
     * @param tbContents
     * @return
     */
    public static  List<TbContentDTO> getContentCopytoDto (List<TbContent> tbContents){
        List<TbContentDTO> list = new ArrayList<>();
        for (TbContent tbContent : tbContents) {
            TbContentDTO dto = new TbContentDTO();
            BeanUtils.copyProperties(tbContent,dto);
            filterUnnecessaryProperty(dto,tbContent);
            list.add(dto);
        }
        return list;
    }


    public static  void filterUnnecessaryProperty(TbContentDTO dto, TbContent tbContent) {
        dto.setUsername(tbContent.getTbUser().getUsername());
        dto.setUserId(tbContent.getTbUser().getId());

        dto.setTbContentCategoryId(tbContent.getTbContentCategory().getId());
        dto.setTbContentCategoryName(tbContent.getTbContentCategory().getName());
    }

}
