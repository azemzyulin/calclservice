package ru.calcapi.calclservice;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.calcapi.calclservice.schemas.calc.*;

@RestController
@Api(tags = "Calculate")
public class CalcRestController {
    @Autowired
    SOAPConnector soapConnector;

    @PostMapping("/add")
    public BaseResponse addMap(@RequestBody BaseRequest request) {
        Add actionRequest = new Add();
        actionRequest.setIntA(request.getIntA());
        actionRequest.setIntB(request.getIntB());
        AddResponse soapResponse = soapConnector.getCalcResult(actionRequest, AddResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getAddResult());
        return response;
    }

    @PostMapping("/multiply")
    public BaseResponse multiplyMap(@RequestBody BaseRequest request) {
        Multiply actionRequest = new Multiply();
        actionRequest.setIntA(request.getIntA());
        actionRequest.setIntB(request.getIntB());
        MultiplyResponse soapResponse = soapConnector.getCalcResult(actionRequest, MultiplyResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getMultiplyResult());
        return response;
    }

    @PostMapping("/divide")
    public BaseResponse divideMap(@RequestBody BaseRequest request) {
        Divide actionRequest = new Divide();
        actionRequest.setIntA(request.getIntA());
        actionRequest.setIntB(request.getIntB());
        DivideResponse soapResponse = soapConnector.getCalcResult(actionRequest, DivideResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getDivideResult());
        return response;
    }

    @PostMapping("/subtract")
    public BaseResponse subtractMap(@RequestBody BaseRequest request) {
        Subtract actionRequest = new Subtract();
        actionRequest.setIntA(request.getIntA());
        actionRequest.setIntB(request.getIntB());
        SubtractResponse soapResponse = soapConnector.getCalcResult(actionRequest, SubtractResponse.class);
        BaseResponse response = new BaseResponse(soapResponse.getSubtractResult());
        return response;
    }

}

