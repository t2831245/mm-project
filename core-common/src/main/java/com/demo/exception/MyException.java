package com.demo.exception;

public class MyException extends RuntimeException {

    private Integer code;
    private ResourceType resourceType;
    private ReasonType reasonType;
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public MyException(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    public MyException(ResourceType resourceType, ReasonType reasonType) {
        this.message = String.format("%s is %s", resourceType, reasonType.getDescription());
        this.resourceType = resourceType;
        this.reasonType = reasonType;
    }

    public String getMessage(){
        return message;
    }
}
