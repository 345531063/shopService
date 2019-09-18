package com.cheap.service;

import com.cheap.common.MyResponse;
import com.cheap.model.UserKeyWords;


public interface SearchService {
    MyResponse querySearchKeywords(UserKeyWords userKeyWords);
}
