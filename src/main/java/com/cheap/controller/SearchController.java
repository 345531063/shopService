package com.cheap.controller;


import com.cheap.common.MyResponse;
import com.cheap.constant.ErrorCodeEnum;
import com.cheap.model.UserKeyWords;
import com.cheap.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/search"})
@Slf4j
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = {"/querySearchKeywords"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public MyResponse querySearchKeywords(@RequestBody UserKeyWords userKeyWords){
        Integer number = userKeyWords.getNumber();
        if(number == null) {
            MyResponse myResponse = MyResponse.error(ErrorCodeEnum.KEYWORD_ISNOT);
            return myResponse;
        }
        MyResponse myResponse = searchService.querySearchKeywords(userKeyWords);
       // log.info("Res:{}", myResponse);
        return myResponse;
    }
}
