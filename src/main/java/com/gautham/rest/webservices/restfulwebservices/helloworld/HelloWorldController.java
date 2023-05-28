package com.gautham.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(path = "/helloBean")
    public HelloWorldBean helloworldBean() {
        return new HelloWorldBean("Hello World Bean!");
    }

    @GetMapping(path = "/helloBean/{message}")
    public HelloWorldBean helloworldBeanName(@PathVariable String message) {
        return new HelloWorldBean(String.format("Hello %s!", message));
    }

}