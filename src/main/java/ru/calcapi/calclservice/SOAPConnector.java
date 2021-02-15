package ru.calcapi.calclservice;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SOAPConnector extends WebServiceGatewaySupport {

    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request,webServiceMessage -> {
            ((SoapMessage)webServiceMessage).setSoapAction(
                    "https://www.w3schools.com/xml/CelsiusToFahrenheit" );
        } );
    }
}
