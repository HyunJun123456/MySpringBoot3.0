package com.basic.myspringboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Order(1) // 숫자가 낮을수록 우선순위가 높음
public class MyRunner implements ApplicationRunner {

    @Value("${myboot.name}") // 자주 바꾸는걸 환경 변수로 사용해서 바꿈
    private String name;
    @Value("${myboot.age}")
    private int age;
    @Value("${myboot.fullName}")
    private String fullName;

    @Autowired
    private Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // environment injection을 받아서 처리 가능
        System.out.println("port number: "+environment.getProperty("local.server.port"));
        /*하지만 VM arguments(-D)는 ApplicationArguments에 포함되지 않습니다.
        VM arguments는 JVM 자체의 옵션으로, Spring Boot의 ApplicationArguments 객체에는 전달되지 않습니다.
        따라서, "foo" 옵션을 VM arguments로 전달했다면 args.containsOption("foo")는 항상 false를 반환할 것입니다.*/
        System.out.println("VM Args: foo: " + args.containsOption("foo")); // VM은 -D
        System.out.println("PRO Args: bar: " + args.containsOption("bar")); // Program은 --
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("fullName = " + fullName);
    }

}
