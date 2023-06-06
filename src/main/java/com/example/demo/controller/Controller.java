package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller {

    @GetMapping(value = "/value",produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Map<String, String>> getValue(@Value("${value}") String value){
        Map<String,String> data=new HashMap<>();
        data.put("value",value);
        log.info("Testing success !!");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(data);
    }
}