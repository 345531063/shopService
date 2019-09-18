package com.cheap.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cheap.common.MyResponse;
import com.cheap.common.PageInfo;
import com.cheap.model.TbkItemModel;
import com.github.pagehelper.Page;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.cheap.constant.ErrorCodeEnum.KEYWORD_ISNOT;

@Slf4j
@RestController
@RequestMapping(value = {"/tk"})
@CrossOrigin
public class TaobaoApi {
    public static final String url = "http://gw.api.taobao.com/router/rest";


    public static final String appkey = "27732831";

    public static final String secret = "6bdf6f96cd31af439313632ca5ba7eb9";


    /**
     * 获取商品列表
     * @return
     */
    @RequestMapping(value = {"/queryGoods"},method = RequestMethod.POST)
    public MyResponse getTbkItem(@RequestBody TbkItemModel tbkItemModel) throws ApiException {

        if ( tbkItemModel.getQ() == null) {
            MyResponse myResponse = MyResponse.error(KEYWORD_ISNOT);
            return  myResponse;
        }
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkDgMaterialOptionalRequest request = new TbkDgMaterialOptionalRequest();
        request.setQ(tbkItemModel.getQ());
//        request.setIsTmall(tbkItemModel.getIsTmall());
//        request.setIsOverseas(tbkItemModel.getIsOverseas());
        request.setPlatform(tbkItemModel.getPlatform());
        request.setPageNo(tbkItemModel.getPageNo());
        request.setAdzoneId(109238150492L);
        request.setPageSize(tbkItemModel.getPageSize());
        TbkDgMaterialOptionalResponse response = client.execute(request);
        //log.info("response: {}", response);
        PageInfo pageInfo = new PageInfo(response.getResultList(), response.getTotalResults());
        MyResponse myResponse = MyResponse.success(pageInfo, response.getResultList());
        return myResponse;
    }

    /**
     * 首页数据
     * @return
     */
    @RequestMapping(value = {"/indexDataList"},method = RequestMethod.POST)
    public MyResponse indexDataList( TbkItemModel tbkItemModel) throws ApiException {

        String  pp = "[{\n" +
                "\t\tsrc: \"/static/temp/banner3.jpg\",\n" +
                "\t\tbackground: \"rgb(203, 87, 60)\",\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\tsrc: \"/static/temp/banner2.jpg\",\n" +
                "\t\tbackground: \"rgb(205, 215, 218)\",\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\tsrc: \"/static/temp/banner4.jpg\",\n" +
                "\t\tbackground: \"rgb(183, 73, 69)\",\n" +
                "\t}\n" +
                "]";
        JSONArray  jsonObject = JSONArray.parseArray(pp);

        MyResponse myResponse = MyResponse.success(jsonObject);
        return myResponse;
    }

}
