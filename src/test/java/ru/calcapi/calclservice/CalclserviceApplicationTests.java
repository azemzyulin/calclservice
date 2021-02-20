package ru.calcapi.calclservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.calcapi.calclservice.conf.Config;
import ru.calcapi.calclservice.schemas.calc.Add;
import ru.calcapi.calclservice.schemas.calc.AddResponse;
import ru.calcapi.calclservice.service.SOAPConnector;

@SpringBootTest
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
class CalclserviceApplicationTests {
    @Autowired
    SOAPConnector soapConnector;

    @Test
    public void contextLoads() {
        int a =2;
        int b =2;
        Add add = new Add();
        add.setIntA(2);
        add.setIntB(3);
        AddResponse response = soapConnector.getCalcResult(add, AddResponse.class);
        System.out.println("Got Response As below ========= : ");
        System.out.println("Add : "+ a + "+" + b +" = " + response.getAddResult());
        System.out.println("------------");
    }

}
