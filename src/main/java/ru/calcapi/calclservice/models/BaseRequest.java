package ru.calcapi.calclservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
public class BaseRequest {
    @Pattern(regexp = "^-?\\d{1,10}\\b", message = "intA must by int")
    private String intA;
    @Pattern(regexp = "^-?\\d{1,10}\\b", message = "intB must by int")
    private String intB;
}
