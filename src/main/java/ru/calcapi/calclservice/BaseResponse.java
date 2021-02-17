package ru.calcapi.calclservice;

import lombok.Data;

@Data
public class BaseResponse {

    private final String status;
    private final Integer result;

    public BaseResponse(String status, Integer code) {
        this.status = status;
        this.result = code;
    }


}
