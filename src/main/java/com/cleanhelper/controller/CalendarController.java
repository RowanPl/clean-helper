package com.cleanhelper.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Value("${google.api.key}")
    private String googleApiKey;

    @GetMapping("/api-key")
    public Map<String, String> getApiKey() {
        return Map.of("apiKey", googleApiKey);
    }
}

