package ru.calcapi.calclservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.calcapi.calclservice.schemas.calc.Add;
import ru.calcapi.calclservice.schemas.calc.AddResponse;

public class SOAPConnector extends WebServiceGatewaySupport {

    public <T> T getCalcResult(Object request, Class<T> responseClass){
        String soapAction = "http://tempuri.org/"+responseClass.getSimpleName().replace("Response","");
        T response = (T) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(soapAction));
        return response;
    }
}
