package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.utilities.DemoUtilities;

@Service
public class DemoService {

    public Map<String, String> getProcessData(String value){
        Map<String, String> data = new HashMap<>();

        data.put("value", value);
        data.put("docker host name", DemoUtilities.getHostName());
        return data;
    }
    
}
