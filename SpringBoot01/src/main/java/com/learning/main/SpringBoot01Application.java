package com.learning.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.naming.Context;

@SpringBootApplication
public class SpringBoot01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext Context = SpringApplication.run(SpringBoot01Application.class, args);

    }

}
