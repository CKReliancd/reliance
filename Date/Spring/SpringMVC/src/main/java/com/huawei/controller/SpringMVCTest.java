package com.huawei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "/springmvc/success.html";

    @RequestMapping(value="/testRest/{id}" , method = RequestMethod.GET)
    public String testRest(@PathVariable String id){
        System.out.println("testRest GET:" + id);
        return SUCCESS;
    }
    @RequestMapping(value="/testRest" , method = RequestMethod.POST)
    public String testRest(){
        System.out.println("testRest POST:");
        return SUCCESS;
    }
    @RequestMapping(value="/testRest/{id}" , method = RequestMethod.DELETE)
    public String testRestDELETE(@PathVariable String id){
        System.out.println("testRest DELETE:" + id);
        return SUCCESS;
    }
    @RequestMapping(value="/testRest/{id}" , method = RequestMethod.PUT)
    public String testRestPUT(@PathVariable String id){
        System.out.println("testRest PUT:" + id);
        return SUCCESS;
    }

}
