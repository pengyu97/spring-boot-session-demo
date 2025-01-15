package com.jay;

import lombok.Data;

/**
 * @author xiang.wei
 * @create 2019/2/19 14:22
 */
@Data
public class ReturnData {
    private int code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public ReturnData() {
    }

    public ReturnData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static ReturnData success(String msg,Object data) {
        ReturnData returnData = new ReturnData();
        returnData.setCode(200);
        returnData.setMsg(msg == null ? "成功" : msg);
        returnData.setData(data);
        return returnData;
    }

    public static ReturnData fail(int code, String msg, Object data) {
        ReturnData returnData = new ReturnData();
        returnData.setCode(code);
        returnData.setMsg(msg);
        returnData.setData(data);
        return returnData;
    }

}
