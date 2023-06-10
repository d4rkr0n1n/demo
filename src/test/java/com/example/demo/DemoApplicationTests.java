package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void mainMethodStartsApplication() {
        String[] args = {};
        assertDoesNotThrow(() -> DemoApplication.main(args));
    }

}
