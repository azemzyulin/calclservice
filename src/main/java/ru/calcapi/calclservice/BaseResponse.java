package ru.calcapi.calclservice;

import lombok.Data;

@Data
public class BaseResponse {

    private final Integer result;

    public BaseResponse(Integer code) {
        this.result = code;
    }


}
