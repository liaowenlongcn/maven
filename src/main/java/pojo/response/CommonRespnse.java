package pojo.response;

import pojo.enums.ResultCode;

/**
 * Created by wenlong.liao on 2018/9/1.
 */
public class CommonRespnse<T> {

    private   boolean isSuccess;

    private Integer resultCode;

    private T body;

    private String message;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        this.isSuccess = success;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode.getValue();
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
