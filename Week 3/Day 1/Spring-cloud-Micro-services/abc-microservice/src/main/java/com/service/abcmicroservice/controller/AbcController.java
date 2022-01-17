package com.service.abcmicroservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/abc")
@RestController
public class AbcController {
    @GetMapping
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("Iam From ABC CONTROLLER");
    }
}
