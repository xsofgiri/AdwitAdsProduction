package com.production.util;

import com.production.entity.ApiResponseCode;
import com.production.enums.ApiResponseEnum;

/**
 * web层统一返回工具类
 * @author qiaokun
 * @date 2018/07/18
 */
public class ApiResponseUtil {

    /**
     *Get the successful response of the request ApiResponse
     * @param data
     * @return
     */
    public static ApiResponseCode getApiResponse(Object data) {
        return getApiResponse(data, ApiResponseEnum.SUCCESS.getResponseCode(), ApiResponseEnum.SUCCESS.getResponseMsg());
    }

    /**
     * Get the response of other requests ApiResponse
     * @param code
     * @param msg
     * @return
     */
    public static ApiResponseCode getApiResponse(int code,String msg) {
        return getApiResponse(null, code, msg);
    }

    /**
     * Convert enumeration information to unified return object
     * @param apiResponseEnum
     * @return
     */
    public static ApiResponseCode getApiResponse(ApiResponseEnum apiResponseEnum){
        return  getApiResponse(apiResponseEnum.getResponseCode(),apiResponseEnum.getResponseMsg());
    }


    public static ApiResponseCode getApiResponse(Object data, int code, String msg) {
    	ApiResponseCode apiResponse = new ApiResponseCode(data);
        apiResponse.setResponseCode(code);
        apiResponse.setResponseMsg(msg);
        return apiResponse;
    }


}
