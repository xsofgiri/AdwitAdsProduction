package com.production.entity;

import com.production.enums.ApiResponseEnum;

/**
 * web层统一返回类型
 * @author qiaokun
 * @date 2018/07/18
 */
public class ApiResponseCode {
    private int responseCode = 0;
    private String responseMsg;

    private Object data;

    public ApiResponseCode(){

    }


    public ApiResponseCode(Object data) {
        this.data = data;
    }

    public ApiResponseCode(ApiResponseEnum apiResponseEnum){
        this.responseCode = apiResponseEnum.getResponseCode();
        this.responseMsg = apiResponseEnum.getResponseMsg();
    }

   

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "responseCode=" + responseCode +
                ", responseMsg='" + responseMsg + '\'' +
                ", data=" + data +
                '}';
    }


	public int getResponseCode() {
		return responseCode;
	}


	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}


	public String getResponseMsg() {
		return responseMsg;
	}


	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
}
