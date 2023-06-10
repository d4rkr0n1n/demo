package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(value = "local")
@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {

    @Spy
    private DemoService demoService;

    @Test
    public void testGetHostname() {
        assertTrue(demoService.getProcessData("local").get("value") == "local");

    }
}
