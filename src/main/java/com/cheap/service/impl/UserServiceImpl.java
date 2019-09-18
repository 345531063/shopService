package com.cheap.service.impl;

import com.cheap.dao.UserInfoMapper;
import com.cheap.entity.User;
import com.cheap.service.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserInfoMapper userDao;

    @Override
    public List findAllUser(int pageNum, int pageSize){
       // 引入分布插件
       Page page =  PageHelper.startPage(pageNum, pageSize);
       List<User> list = userDao.findAllUser();
//       PageInfo<User> info = new PageInfo<User>(list);
//       log.info("page:{}",info);
       return list;
    }
}
