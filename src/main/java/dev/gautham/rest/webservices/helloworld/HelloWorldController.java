package dev.gautham.rest.webservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/bean")
    public HelloWorldBean helloworldBean() {
        return new HelloWorldBean("Hello World Bean!");
    }

    @GetMapping("/{message}")
    public HelloWorldBean helloWorldBeanName(@PathVariable String message) {
        return new HelloWorldBean(String.format("Hello %s!", message));
    }

}