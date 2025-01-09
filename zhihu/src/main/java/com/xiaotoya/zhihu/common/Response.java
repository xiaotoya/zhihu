package com.xiaotoya.zhihu.common;

import java.util.HashMap;

public class Response {
    private int code;
    private String msg;
    private HashMap<String, Object> data = new HashMap<>();
    private Boolean success;

    private Response() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public static Response ok() {
        Response response = new Response();
        response.setSuccess(true);
        response.setCode(ResultCode.SUCCESS);
        response.setMsg("成功");
        return response;
    }

    public static Response error() {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(ResultCode.FAIL);
        response.setMsg("失败");
        return response;
    }

    public Response message(String message) {
        this.setMsg(message);
        return this;
    }

    public Response data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
    public Response data(HashMap<String, Object> data) {
        this.setData(data);
        return this;
    }

    public Response code(int code) {
        this.setCode(code);
        return this;
    }
    public Response success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
}
