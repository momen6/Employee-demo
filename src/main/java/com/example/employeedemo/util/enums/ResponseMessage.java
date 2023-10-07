package com.example.employeedemo.util.enums;

import lombok.Getter;

@Getter
public enum ResponseMessage {

    SUCCESS(200L),
    FAIL(500L);

    private Long code;

    ResponseMessage(Long code) {
        this.code = code;
    }

}
