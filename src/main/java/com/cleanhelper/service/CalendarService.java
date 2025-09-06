package com.cleanhelper.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

/**
 * Service responsible for retrieving calendar information from the
 * Google Calendar API using the configured API key. The API key is
 * used only on the server side and is never exposed to the client.
 */
@Service
public class CalendarService {

    @Value("${google.api.key}")
    private String googleApiKey;

    private final RestTemplate restTemplate;

    public CalendarService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * Fetches the user's primary calendar events from Google Calendar.
     *
     * @return a map containing the events or an error message if the
     *         events could not be retrieved
     */
    public Map<String, Object> getCalendarEvents() {
        String url = "https://www.googleapis.com/calendar/v3/calendars/primary/events?key=" + googleApiKey;
        try {
            return restTemplate.getForObject(url, Map.class);
        } catch (Exception ex) {
            return Collections.singletonMap("error", "Unable to fetch calendar events");
        }
    }
}
