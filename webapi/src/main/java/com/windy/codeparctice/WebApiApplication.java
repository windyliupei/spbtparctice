package com.windy.codeparctice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.windy.codeparctice")
public class WebApiApplication {

    public static void main(String args[]){
        SpringApplication.run(WebApiApplication.class, args);
    }

}
