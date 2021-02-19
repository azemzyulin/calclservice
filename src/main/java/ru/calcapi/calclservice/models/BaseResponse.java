package ru.calcapi.calclservice.models;

import lombok.Data;

@Data
public class BaseResponse {

    private final Integer result;

    public BaseResponse(Integer code) {
        this.result = code;
    }


}
