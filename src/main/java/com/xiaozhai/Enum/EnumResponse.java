package com.xiaozhai.Enum;

public enum EnumResponse {

    CODESUCCESS(200,"SUCCESS"),
    CODEERROR(500,"ERROR"),
    CODENOTFOUND(404,"NOT FOUND");

    private int code;
    private String msg;

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

    EnumResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
