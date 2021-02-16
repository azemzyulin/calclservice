package ru.calcapi.calclservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.calcapi.calclservice.schemas.calc.Add;
import ru.calcapi.calclservice.schemas.calc.AddResponse;

@SpringBootApplication
public class CalclserviceApplication {


    public static void main(String[] args) {
        SpringApplication.run(CalclserviceApplication.class, args);}

    }





