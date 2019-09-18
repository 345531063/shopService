package com.cheap.constant;


import lombok.Data;
import org.springframework.stereotype.Component;


public enum ErrorCodeEnum {
    SUCCESS(1,"10000","SUCCESS","成功"),
    ERROR( 2, "20001", "server is error","服务器繁忙"),
    KEYWORD_ISNOT(3,"20002", "The search keyword is error!", "搜索关键字错误!"),
    ;

    private int id;
    private String code;
    private String enText;
    private String cnText;

    ErrorCodeEnum(int id, String code, String enText, String cnText){
        this.id = id;
        this.code = code;
        this.enText=enText;
        this.cnText=cnText;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCnText() {
        return cnText;
    }

    public void setCnText(String cnText) {
        this.cnText = cnText;
    }

    public String getEnText() {
        return enText;
    }

    public void setEnText(String enText) {
        this.enText = enText;
    }

}
