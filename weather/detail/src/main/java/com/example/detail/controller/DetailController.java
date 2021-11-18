package com.example.detail.controller;

import com.example.detail.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailController {
    private final DetailService detailService;


    //当没有override server.port时，默认使用9001端口
    @Value("${server.port}")
    private int serverPort;


    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/port")
    public ResponseEntity<?> getDetails() {
        return new ResponseEntity<>("detail service port is " + serverPort, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?> getIdbyCity(@RequestParam(required = true)String city) {
        return new ResponseEntity<>(detailService.findCityIdByName(city), HttpStatus.OK);
    }
}
