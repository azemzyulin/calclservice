package ru.calcapi.calclservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
public class BaseRequest {
    @Max(value = 2147483647, message = "intA > Integer.MAX")
    @Min(value = -2147483648, message = "intA < Integer.MIN")
    private int intA;
    @Max(value = 2147483647, message = "intB > Integer.MAX")
    @Min(value = -2147483648, message = "intB < Integer.MIN")
    private int intB;
}
