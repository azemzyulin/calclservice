package ru.calcapi.calclservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
public class BaseRequest {
    @Pattern(regexp = "^-?\\d{1,10}\\b", message = "number must by int")
    private String intA;

    @Pattern(regexp = "^-?\\d{1,10}\\b", message = "number must by int")
    private String intB;
}
