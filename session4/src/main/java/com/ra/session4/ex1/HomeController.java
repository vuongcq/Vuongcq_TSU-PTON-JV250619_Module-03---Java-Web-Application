package com.ra.session4.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/ex1")
    public String ex1(){
        return "ex1";
    }
}
