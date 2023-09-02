package com.demo.exception;

public enum ReasonType {
    NOT_FOUND("not found"),
    DUPLICATED("duplicated"),
    FORMAT_INVALID("format invalid"),
    INTERNAL_ERROR("internal error"),
    ;

    private final String description;

    private ReasonType(String shortCode) {
        this.description = shortCode;
    }

    public String getDescription() {
        return description;
    }
}
