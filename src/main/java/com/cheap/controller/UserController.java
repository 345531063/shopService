package com.cheap.controller;

import com.alibaba.fastjson.JSONObject;
import com.cheap.common.PageInfo;
import com.cheap.common.MyResponse;
import com.cheap.entity.User;
import com.cheap.model.UserModel;
import com.cheap.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import sun.misc.FormattedFloatingDecimal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = {"/user"})
@Slf4j
public class UserController {

   // private final Logger log = (Logger) LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    private User user;

//    @ResponseBody
    @RequestMapping(value = {"/find"},method = RequestMethod.POST)
    public MyResponse find(@RequestBody UserModel userModel){
        String userId = userModel.getUserId();
        if (userId != null) {
            List< User> lists = userService.findAllUser(1,5);
//            log.info("list:{}",lists);
//            List< User > list =  lists.stream().filter((User user) -> user.getUserid().equals(userId)) .collect(Collectors.toList());
//            return  list;
            List<String> list = new ArrayList<>();
            lists.forEach( user ->{
                list.add(user.getUserid());
                return;
            });
            MyResponse myResponse = MyResponse.success(list);
            return myResponse;
        }
        MyResponse myResponse = MyResponse.error();
        return myResponse;
    }

    @RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public MyResponse getAllUsers(){
       List list =  userService.findAllUser(1,5);
        PageInfo pageInfo = new PageInfo(list);
        MyResponse myResponse = MyResponse.success(pageInfo, list);
       // log.info("Res:{}", myResponse);
//        PageInfo info = new PageInfo<>(list);
//        log.info("info:{}",info);
       return myResponse;
    }

    @RequestMapping(value = {"/test"})
    public Map<String, JSONObject> test() throws IOException {
        Map<String, JSONObject> maps = new HashMap<>();
        OkHttpClient httpClient = new OkHttpClient();
        String url = "http://www.goushengqian.com/PcApi/index/search";
        // 1.设置媒体类型。application/json表示传递的是一个json格式的对象
//        MediaType mediaType = MediaType.parse("x-www-form-urlencoded");
        // 2.使用JSONObject封装参数
//        JSONObject jsonObject = new JSONObject();Logger
//        jsonObject.put("q","衣服");
        // 3.创建RequestBody对象，将参数按照指定的MediaType封装
//        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(mediaType, jsonObject.toString());
        okhttp3.RequestBody requestBody = new FormBody.Builder().add("q", "衣服").build();
//        // 4.建立请求
        Request request = new Request.Builder().post(requestBody).url(url).build();
        Response response = httpClient.newCall(request).execute();
        try {
            if (response.isSuccessful()) {
                JSONObject result = JSONObject.parseObject(response.body().string());
                //log.info(">>>>result>>>" + result);
                maps.put("result", result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maps;
    }


    }
