package com.lab.product_management_system.customes;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Service;


@Service
@Endpoint(id = "customized")
public class CustomizedActuators {
    @ReadOperation
    public String added () {
        return "this customized actuator";
    }
}
