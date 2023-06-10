package com.example.demo.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.services.DemoService;
import com.example.demo.utilities.DemoUtilities;

@ActiveProfiles(value = "local")
@WebMvcTest(DemoController.class)
public class DemoControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DemoService demoService; 

    @Test
    public void testGetValue() throws Exception {
        Map<String, String> data = new HashMap<>();

        data.put("value", "local");
        data.put("docker host name", DemoUtilities.getHostName());
        when(demoService.getProcessData("local")).thenReturn(data);
        mockMvc.perform(get("/value"))
            .andExpect(status().isAccepted())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.value").value("local"));
    }
}
