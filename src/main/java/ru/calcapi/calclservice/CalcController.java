package ru.calcapi.calclservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    private final SOAPConnector soapConnector;

    @Autowired
    public CalcController(SOAPConnector soapConnector) {
        this.soapConnector = soapConnector;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}