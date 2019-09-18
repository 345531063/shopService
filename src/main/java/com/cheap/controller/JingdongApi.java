package com.cheap.controller;

import com.alibaba.fastjson.JSONObject;
import com.cheap.common.MyResponse;
import com.cheap.common.PageInfo;
import com.cheap.model.TbkItemModel;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import jd.union.open.goods.jingfen.query.request.JFGoodsReq;
import jd.union.open.goods.jingfen.query.request.UnionOpenGoodsJingfenQueryRequest;
import jd.union.open.goods.jingfen.query.response.UnionOpenGoodsJingfenQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.cheap.constant.ErrorCodeEnum.KEYWORD_ISNOT;

@Slf4j
@RestController
@RequestMapping(value = {"/tk"})
public class JingdongApi {
    public static final String url = "http://gw.api.taobao.com/router/rest";


    public static final String appkey = "27732831";

    public static final String secret = "6bdf6f96cd31af439313632ca5ba7eb9";





}
