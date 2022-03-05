package com.dk.unittesting.controller;

import com.dk.unittesting.domain.App;
import com.dk.unittesting.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RequestMapping("/app")
@RestController
public class AppController {

    @Autowired
    private AppService service;

    @GetMapping("/{st}/{ed}")
    public ResponseEntity<List<App>> findApps(@PathVariable String st, @PathVariable  String ed) {
        return ResponseEntity.ok(
                service.findAppsBetween(
                        Date.valueOf(st),
                        Date.valueOf(ed)
                )
        );
    }
}
