package com.passthehash.recipesmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApplicationController {

    @RequestMapping("/")
    public String Index() {
        return "Hello world!";
    }
}
