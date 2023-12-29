package com.practica.Soundufroback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("home")
public class LandingController {

    @GetMapping("welcome")
    protected String welcomePage(){
        return "Welcome home page";
    }
}
