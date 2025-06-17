package com.securityjwt.secjwtoauth2.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HttpController {

    @GetMapping("/public")
     public String publicRoute() {
        return "<h1>Public Route </h1><p>This route is accessible to everyone.</p>";
    }

    @GetMapping("/private")
    public String privateRoute() {
        return "<h1>Private Route </h1><p>This route is accessible only to authenticated users.</p>";
    }   
    

}
