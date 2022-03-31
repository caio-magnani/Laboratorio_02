package com.lab2.alugueldeautomoveis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("")
    public String LandingPage(){
        return "index";
    }
}
