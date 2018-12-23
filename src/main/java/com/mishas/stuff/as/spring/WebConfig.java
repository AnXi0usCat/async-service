package com.mishas.stuff.as.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.as.web"})
public class WebConfig {

    public WebConfig() {
        super();
    }

}

