package com.cheap.common;

import com.cheap.constant.ErrorCodeEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BussinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // 错误码
    private Integer code;

    //错误提示
    private  String msg;

    //返回结果
    private  String result;

    public BussinessException(){}

    public BussinessException(ErrorCodeEnum errorCodeEnum) {
        this.code = Integer.valueOf(errorCodeEnum.getCode());
        this.msg = errorCodeEnum.getCnText();
        this.result = errorCodeEnum.getEnText();
    }

}
