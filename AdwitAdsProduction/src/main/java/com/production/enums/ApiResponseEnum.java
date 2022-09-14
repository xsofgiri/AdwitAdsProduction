package com.production.enums;

/**
 * web Layer return information enumeration
 * @author qiaokun
 * @2018/08/13
 */
public enum ApiResponseEnum {
    /**
     * API The call returns successfully
     */
    SUCCESS(10000,"success request"),
    FAIL(10001,"failed request"),
    LOGIN_FAIL(10099,"invalid login"),
    AUTH_ERROR(10100,"Auth error");

    private int responseCode = 0;
    private String responseMsg;


    private ApiResponseEnum(int responseCode, String responseMsg) {
       this.responseCode = responseCode;
       this.responseMsg = responseMsg;
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
