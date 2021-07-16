package com.example.MediScreen.dto;

public class ResponseDto {
    private int code;
    private String Content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void responseDtoSuccess() {
        setCode(200);
        setContent("success");
    }

    public void responseDtoFailure() {
        setCode(400);
        setContent("Malformed Request");
    }

}
