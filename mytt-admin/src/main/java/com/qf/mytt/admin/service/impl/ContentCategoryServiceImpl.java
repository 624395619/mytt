package com.qf.mytt.admin.service.impl;

import com.qf.mytt.admin.dao.TbContentCategoryDao;
import com.qf.mytt.admin.service.ContentCategoryService;
import com.qf.mytt.domain.TbContentCategory;
import org.springframework.stereotype.Service;

@Service
public class ContentCategoryServiceImpl extends BaseTreeServiceImpl<TbContentCategory, TbContentCategoryDao> implements ContentCategoryService {
    @Override
    public void save(TbContentCategory tbContentCategory) {
        // 如果父类目 ID 为 0，则表示一定是父级类目
        if (tbContentCategory.getParentCategory().getId() == 0) {
            tbContentCategory.setParent(true);
        }

        // 根据父级类目 ID 查询所属类目并将其 isParent 设置为 true
        else {
            TbContentCategory parent = dao.get(tbContentCategory.getParentCategory().getId());
            parent.setParent(true);
            super.save(parent);
        }

        super.save(tbContentCategory);
    }

    /**
     * 联动删除
     * @param id
     */
    @Override
    public void delete(long id) {
        TbContentCategory category = super.get(id);
        TbContentCategory parent = category.getParentCategory();
        int count = super.countByPid(parent.getId());
        if (count == 0 && parent.getParentCategory().getId() != 0) {
            parent.setParent(false);
            super.save(parent);
        }
        super.delete(id);
    }
}
