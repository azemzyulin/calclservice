package ru.calcapi.calclservice.models;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class BaseRequest {
    @Pattern(regexp = "^-?\\d{1,10}\\b", message = "intA must by int")
    private String intA;
    @Pattern(regexp = "^-?\\d{1,10}\\b", message = "intB must by int")
    private String intB;
}
