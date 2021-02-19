package ru.calcapi.calclservice.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.calcapi.calclservice.service.SOAPConnector;
import ru.calcapi.calclservice.models.BaseRequest;
import ru.calcapi.calclservice.models.BaseResponse;
import ru.calcapi.calclservice.schemas.calc.*;

import javax.validation.Valid;

@RestController
@Api(tags = "Calculate")
public class CalcRestController {
    @Autowired
    SOAPConnector soapConnector;

    @PostMapping("/add")
    public ResponseEntity<?> addMap(@RequestBody @Valid BaseRequest request, Errors errors) {
        if (errors.hasFieldErrors()) {
            FieldError fieldError = errors.getFieldError();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(fieldError.getDefaultMessage());
        }
        Add actionRequest = new Add();
        actionRequest.setIntA(Integer.parseInt(request.getIntA()));
        actionRequest.setIntB(Integer.parseInt(request.getIntB()));
        AddResponse soapResponse = soapConnector.getCalcResult(actionRequest, AddResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getAddResult());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/multiply")
    public ResponseEntity<?> multiplyMap(@Valid @RequestBody BaseRequest request, Errors errors) {
        if (errors.hasFieldErrors()) {
            FieldError fieldError = errors.getFieldError();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(fieldError.getDefaultMessage());
        }
        Multiply actionRequest = new Multiply();
        actionRequest.setIntA(Integer.parseInt(request.getIntA()));
        actionRequest.setIntB(Integer.parseInt(request.getIntB()));
        MultiplyResponse soapResponse = soapConnector.getCalcResult(actionRequest, MultiplyResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getMultiplyResult());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/divide")
    public ResponseEntity<?> divideMap(@Valid @RequestBody BaseRequest request, Errors errors) {
        if (errors.hasFieldErrors()) {
            FieldError fieldError = errors.getFieldError();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(fieldError.getDefaultMessage());
        }
        Divide actionRequest = new Divide();
        actionRequest.setIntA(Integer.parseInt(request.getIntA()));
        actionRequest.setIntB(Integer.parseInt(request.getIntB()));
        DivideResponse soapResponse = soapConnector.getCalcResult(actionRequest, DivideResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getDivideResult());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/subtract")
    public ResponseEntity<?> subtractMap(@Valid @RequestBody BaseRequest request, Errors errors) {
        if (errors.hasFieldErrors()) {
            FieldError fieldError = errors.getFieldError();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(fieldError.getDefaultMessage());
        }
        Subtract actionRequest = new Subtract();
        actionRequest.setIntA(Integer.parseInt(request.getIntA()));
        actionRequest.setIntB(Integer.parseInt(request.getIntB()));
        SubtractResponse soapResponse = soapConnector.getCalcResult(actionRequest, SubtractResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getSubtractResult());
        return ResponseEntity.ok(response);
    }

}

