package com.sequoia.shorturl.exception;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/20
 */
public class DefinitionException extends RuntimeException{

    protected String errorCode;
    protected String errorMsg;

    public DefinitionException(){

    }
    public DefinitionException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
