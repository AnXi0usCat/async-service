package com.mishas.stuff.as.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.mishas.stuff.as.service"})
public class ServiceConfig {

    public ServiceConfig() {
        super();
    }
}
