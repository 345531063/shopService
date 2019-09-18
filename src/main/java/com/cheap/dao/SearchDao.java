package com.cheap.dao;

import com.cheap.entity.KeyWords;
import com.cheap.model.UserKeyWords;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchDao {

    List<KeyWords> querySearchKeywords(UserKeyWords userKeyWords);
}
