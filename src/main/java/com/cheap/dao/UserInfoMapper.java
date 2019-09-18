package com.cheap.dao;
import com.cheap.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {

    int insert(User record);

    int insertSelective(User record);

    List findAllUser();

}