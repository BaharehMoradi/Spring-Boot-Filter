package com.example.springbootfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/students")
    public String hello() {
        return "Hello, Students!";
//Output:
//IpFilter: Logging Request in IpFilter class  GET : /students
//TransactionFilter: Starting a transaction for req in TransactionFilter class : /students
//TransactionFilter: Committing a transaction for req in TransactionFilter class: text/plain;charset=UTF-8
//IpFilter: Logging Response in IpFilter class text/plain;charset=UTF-8 :
    }

    @GetMapping("/users")
    public String users() {
        return "Hello, Users!";
//Output:
//RequestResponseLoggingFilter: Logging Request in RequestResponseLoggingFilter class  GET : /users
//IpFilter: Logging Request in IpFilter class  GET : /users
//IpFilter: Logging Response in IpFilter class text/plain;charset=UTF-8 :
//RequestResponseLoggingFilter: Logging Response in RequestResponseLoggingFilter class text/plain;charset=UTF-8


    }
}