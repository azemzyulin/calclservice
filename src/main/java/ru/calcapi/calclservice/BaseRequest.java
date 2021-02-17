package ru.calcapi.calclservice;

import lombok.Data;

@Data
public class BaseRequest {
    private String action;
    private int intA;
    private int intB;

}
