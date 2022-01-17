package com.service.pqrmicroservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.ResponseCache;

@RequestMapping("/api/pqr")
@RestController
public class PqrController {
    @GetMapping
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("Iam FROM PQR CONTROLLER");
    }
}
