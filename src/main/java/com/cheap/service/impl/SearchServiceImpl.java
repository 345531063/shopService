package com.cheap.service.impl;

import com.cheap.common.MyResponse;
import com.cheap.dao.SearchDao;
import com.cheap.entity.KeyWords;
import com.cheap.entity.User;
import com.cheap.model.UserKeyWords;
import com.cheap.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service(value = "SearchService")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;

    @Override
    public MyResponse querySearchKeywords(UserKeyWords userKeyWords){
        try {
            List<KeyWords> list = searchDao.querySearchKeywords(userKeyWords);
            MyResponse myResponse = MyResponse.success(list);
            return myResponse;
        }catch (Exception e){
            log.info("错误了，{}",e);
            MyResponse myResponse = MyResponse.error();
            return myResponse;
        }
    }
}
