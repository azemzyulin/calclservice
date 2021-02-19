package ru.calcapi.calclservice;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.calcapi.calclservice.models.BaseRequest;
import ru.calcapi.calclservice.models.BaseResponse;
import ru.calcapi.calclservice.schemas.calc.*;
import ru.calcapi.calclservice.service.SOAPConnector;

import javax.validation.Valid;

@RestController
@Api(tags = "Calculate")
public class CalcRestController {
    @Autowired
    SOAPConnector soapConnector;

    @PostMapping("/add")
    public BaseResponse addMap(@RequestBody @Valid BaseRequest request) {
        Add actionRequest = new Add();
        actionRequest.setIntA(Integer.parseInt(request.getIntA()));
        actionRequest.setIntB(Integer.parseInt(request.getIntB()));
        AddResponse soapResponse = soapConnector.getCalcResult(actionRequest, AddResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getAddResult());
        return response;
    }

    @PostMapping("/multiply")
    public BaseResponse multiplyMap(@Valid @RequestBody BaseRequest request) {
        Multiply actionRequest = new Multiply();
        actionRequest.setIntA(Integer.parseInt(request.getIntA()));
        actionRequest.setIntB(Integer.parseInt(request.getIntB()));
        MultiplyResponse soapResponse = soapConnector.getCalcResult(actionRequest, MultiplyResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getMultiplyResult());
        return response;
    }

    @PostMapping("/divide")
    public BaseResponse divideMap(@Valid @RequestBody BaseRequest request) {
        Divide actionRequest = new Divide();
        actionRequest.setIntA(Integer.parseInt(request.getIntA()));
        actionRequest.setIntB(Integer.parseInt(request.getIntB()));
        DivideResponse soapResponse = soapConnector.getCalcResult(actionRequest, DivideResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getDivideResult());
        return response;
    }

    @PostMapping("/subtract")
    public BaseResponse subtractMap(@Valid @RequestBody BaseRequest request) {
        Subtract actionRequest = new Subtract();
        actionRequest.setIntA(Integer.parseInt(request.getIntA()));
        actionRequest.setIntB(Integer.parseInt(request.getIntB()));
        SubtractResponse soapResponse = soapConnector.getCalcResult(actionRequest, SubtractResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getSubtractResult());
        return response;
    }

}

