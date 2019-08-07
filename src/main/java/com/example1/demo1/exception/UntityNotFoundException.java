package com.example1.demo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "unityRequest Not found")
public class UntityNotFoundException  extends RuntimeException {
    public UntityNotFoundException(String errorMsg){
        super("无实体信息");
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }

}
