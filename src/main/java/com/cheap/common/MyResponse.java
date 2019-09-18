package com.cheap.common;

import com.cheap.constant.ErrorCodeEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@Slf4j
@Component
public class MyResponse {

    // 提示码
    private int code;
    // 原因
    private String message;
    // 结果
    private Object result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public MyResponse(){

    }


    /**
     * 成功返回不带结果
     * @return
     */
    public static MyResponse success(){
        MyResponse myResponse = new MyResponse();
        myResponse.setCode(Integer.valueOf(ErrorCodeEnum.SUCCESS.getCode()));
        myResponse.setMessage(ErrorCodeEnum.SUCCESS.getCnText());

        return myResponse;
    }

    /**
     * 成功返回
     * @param result
     * @return
     */
    public static MyResponse success(Object result){
        MyResponse myResponse = new MyResponse();
        myResponse.setCode(Integer.valueOf(ErrorCodeEnum.SUCCESS.getCode()));
        myResponse.setMessage(ErrorCodeEnum.SUCCESS.getCnText());
        myResponse.setResult(result);

        return myResponse;
    }

    /**
     * 成功返回, 增加分页
     * @param pageInfo
     * @param list
     * @return
     */
    public static MyResponse success(PageInfo pageInfo, List list){
        MyResponse myResponse = new MyResponse();
        myResponse.setCode(Integer.valueOf(ErrorCodeEnum.SUCCESS.getCode()));
        myResponse.setMessage(ErrorCodeEnum.SUCCESS.getCnText());
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("data", list);
        map.put("pageInfo", pageInfo);
        myResponse.setResult(map);

        return myResponse;
    }

    /**
     * 无特定错误代码的错误返回
     * @return
     */
    public static MyResponse error() {
        MyResponse myResponse = new MyResponse();
        myResponse.setCode(Integer.valueOf(ErrorCodeEnum.ERROR.getCode()));
        myResponse.setMessage(ErrorCodeEnum.ERROR.getCnText());

        return myResponse;
    }

    /**
     * 带错误代码的错误返回
     * @param errorCodeEnum
     * @return
     */
    public static MyResponse error(ErrorCodeEnum errorCodeEnum) {
        MyResponse myResponse = new MyResponse();
        myResponse.setCode(Integer.valueOf(errorCodeEnum.getCode()));
        myResponse.setMessage(errorCodeEnum.getCnText());

        return myResponse;
    }



}
