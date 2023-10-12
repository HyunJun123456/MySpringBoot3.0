package com.basic.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringBoot3Application {

    public static void main(String[] args) {
//        SpringApplication.run(MySpringBoot3Application.class, args);
        SpringApplication application = new SpringApplication(MySpringBoot3Application.class);
        application.setWebApplicationType(WebApplicationType.SERVLET); // 기본은 서블릿
        application.run(args);

    }


}
