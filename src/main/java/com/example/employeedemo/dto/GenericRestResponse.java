package com.example.employeedemo.dto;

import com.example.employeedemo.util.enums.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericRestResponse<T> {

    private T date;
    private ResponseMessage responseMessage;
    private Long responseCode;
    private String errorMessage;
}
