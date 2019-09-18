package com.cheap.common;

import com.cheap.constant.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody

    public MyResponse defaultExceptionHandler(Exception e) {
//        e.printStackTrace();
        log.info("sfdsdfsdfds{}",e);
        if ( e instanceof BussinessException) {
            log.info("业务异常:{}",e);
            BussinessException bussinessException = (BussinessException)e;
            MyResponse myResponse = new MyResponse();
            myResponse.setMessage(bussinessException.getMsg());
            myResponse.setCode(bussinessException.getCode());
            myResponse.setResult(bussinessException.getResult());

            return myResponse;
        }

        MyResponse myResponse = MyResponse.error(ErrorCodeEnum.ERROR);
        return myResponse;


    }
}
