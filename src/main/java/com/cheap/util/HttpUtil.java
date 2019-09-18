package com.cheap.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class HttpUtil {
    /**
     * 给定特定的url，参数封装成一个map,get请求
     * @param url
     * @param params
     * @return 响应字符串
     */
    private static OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static String getResponseWithParams(String url, Map<String,String> params) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        HttpUrl.Builder builder = httpUrl.newBuilder();
        if(params!=null){
            for(String key:params.keySet()){
                builder.addQueryParameter(key,params.get(key));
            }
        }

        Request request = new  Request.Builder()
                .url(builder.build())
                .build();

        try {
            String res = client.newCall(request).execute().body().string();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

        /* 异步处理 */
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
    }

    /**
     * 向url发送get请求
     * @param url
     * @return 返回的字符串
     */
    public static String getResponse(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            String res = client.newCall(request).execute().body().string();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post请求 参数是map格式
     * @param url
     * @param params
     * @return
     */
    public static String postResponseWithParamsInMap(String url,Map<String,String> params){
        FormBody.Builder builder = new FormBody.Builder();
        if(params!=null){
            for(String key:params.keySet()){
                builder.add(key,params.get(key));
            }
        }

        RequestBody body = builder.build();

        Request request = new Request.Builder().url(url).post(body).build();

        try {
            String res = client.newCall(request).execute().body().string();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 参数是json 格式
     * @param url
     * @param json
     * @return
     */
    public static String postResponseWithParamsInJson(String url,String json){

        RequestBody body = RequestBody.create(JSON,json);

        Request request = new Request.Builder().url(url).post(body).build();

        try {
            String res = client.newCall(request).execute().body().string();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
