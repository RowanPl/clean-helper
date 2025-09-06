package com.cleanhelper.controller;

import com.cleanhelper.service.CalendarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller responsible for exposing calendar information.
 * Instead of leaking the API key, it fetches the user's calendar
 * via the Google Calendar API and returns the events.
 */
@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/events")
    public Map<String, Object> getCalendarEvents() {
        return calendarService.getCalendarEvents();
    }
}

