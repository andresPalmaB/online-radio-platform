package com.onlineradioplatform.radioapi.controller;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HealthControllerTest {

    @Test
    void shouldReturnUpStatus() {
        HealthController controller = new HealthController();

        Map<String, String> response = controller.getHealth();

        assertEquals("UP", response.get("status"));
    }
}
