package ru.calcapi.calclservice;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.calcapi.calclservice.schemas.calc.ActionI;
import ru.calcapi.calclservice.schemas.calc.Add;
import ru.calcapi.calclservice.schemas.calc.AddResponse;


@RestController
public class CalcRestController {
    @Autowired
    SOAPConnector soapConnector;

    @PostMapping("/")
    public Integer baseMap(@RequestBody BaseRequest request) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> requestClazz = Class.forName("ru.calcapi.calclservice.schemas.calc." + request.getAction());
        ActionI actionRequest = (ActionI) requestClazz.newInstance();
        actionRequest.setIntA(request.getIntA());
        actionRequest.setIntB(request.getIntB());
        AddResponse response = soapConnector.getCalcResult(actionRequest, AddResponse.class);
        return response.getAddResult();
        }
    }

