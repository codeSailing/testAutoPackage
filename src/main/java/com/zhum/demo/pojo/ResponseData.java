package com.zhum.demo.pojo;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author: zhum
 * @description: 响应工具类
 * @create: 2018-10-11 15:15
 **/
public class ResponseData implements Serializable{
    private static final long serialVersionUID = 1143287635399905813L;
    private String message;
    private Object data;
    private int status;//0 成功 -1 失败

    public static ResponseData getSuccessResponse(Object data){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(0);
        responseData.setData(data);
        responseData.setMessage("请求成功!");
        return responseData;
    }

    public static ResponseData getSuccessResponse(String message){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(0);
        if(!StringUtils.isEmpty(message)){
            responseData.setMessage(message);
        }
        responseData.setMessage("请求成功");
        return responseData;
    }

    public static ResponseData getErrorResponse(String message){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(-1);
        if(!StringUtils.isEmpty(message)){
            responseData.setMessage(message);
        }
        responseData.setMessage("请求失败!");
        return responseData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
