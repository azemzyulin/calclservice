package ru.calcapi.calclservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.calcapi.calclservice.schemas.calc.Add;
import ru.calcapi.calclservice.schemas.calc.AddResponse;

@SpringBootTest
class CalclserviceApplicationTests {
    @Autowired
    SOAPConnector soapConnector;

    @Test
    void contextLoads() {
//        int a =2;
//        int b =2;
//        Add request = new Add();
//        request.setIntA(a);
//        request.setIntB(b);
//        AddResponse response =(AddResponse) soapConnector.callWebService(soapConnector.getDefaultUri(), request);
//        System.out.println("Got Response As below ========= : ");
//        System.out.println("Add : "+ a + "+" + b +" = " + response.getAddResult());
    }

}
