package com.qf.mytt.admin.service.impl;


import com.qf.mytt.admin.dao.TbContentDao;
import com.qf.mytt.admin.service.ContentService;
import com.qf.mytt.domain.TbContent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class ContentServiceImpl extends BaseServiceImpl<TbContent, TbContentDao> implements ContentService {


    @Override
    @Transactional(readOnly = false)
    public void save(TbContent tbContent) {
        if(tbContent.getId()==0){
            UUID uuid = UUID.randomUUID();
            String str = uuid.toString();
            String uuidStr = str.replace("-", "");
            tbContent.setUrl(uuidStr);
            tbContent.setCreated(new Date());
            tbContent.setUpdated(new Date());
            insert(tbContent);
        }

        else{
            tbContent.setUpdated(new Date());
            update(tbContent);
        }
    }
}
