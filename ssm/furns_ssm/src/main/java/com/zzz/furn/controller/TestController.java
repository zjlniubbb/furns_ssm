package com.zzz.furn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@Controller
public class TestController {

    @RequestMapping(value = "/hi")
    public String hi(){
        System.out.println("TestController-hi()........");
        return "hi";
    }

}
