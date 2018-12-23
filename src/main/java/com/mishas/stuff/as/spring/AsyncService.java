package com.mishas.stuff.as.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import({
        ServiceConfig.class,
        WebConfig.class,
        RepositoryConfig.class
})
public class AsyncService {

    public static void main(String... args) {
        SpringApplication.run(AsyncService.class, args);
    }
}
