package com.uploadfiles.resp;

import lombok.Data;

@Data
public class RespData {
    private Integer code;
    private String msg;
    private Object data;

    private RespData(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private RespData(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    private RespData(Integer code, Object data) {
        super();
        this.code = code;
        this.msg = "success";
        this.data = data;
    }


    public static RespData success(Integer code, String msg, Object data){
        return new RespData(code, msg, data);
    }


    public static RespData success(Integer code, Object data) {
        return new RespData(code, data);
    }

    public static RespData success(Integer code, String msg) {
        return new RespData(code, msg);
    }

    public static RespData error(Integer code, String msg) {
        return new RespData(code, msg);
    }


}
