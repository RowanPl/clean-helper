package com.cleanhelper.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Events;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Service responsible for retrieving calendar information from the
 * Google Calendar API using OAuth 2.0 credentials. Access and refresh
 * tokens are stored locally and automatically refreshed when needed.
 */
@Service
public class CalendarService {

    private static final String APPLICATION_NAME = "Clean Helper";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = List.of(CalendarScopes.CALENDAR_READONLY);

    private final String credentialsFile;

    public CalendarService(@Value("${google.credentials.file}") String credentialsFile) {
        this.credentialsFile = credentialsFile;
    }

    private Credential authorize(NetHttpTransport httpTransport) throws IOException {
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new FileReader(credentialsFile));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();

        Credential credential = flow.loadCredential("user");
        if (credential != null) {
            return credential;
        }
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    /**
     * Fetches the user's primary calendar events from Google Calendar.
     *
     * @return a map containing the events or an error message if the
     *         events could not be retrieved
     */
    public Map<String, Object> getCalendarEvents() {
        try {
            NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            Credential credential = authorize(httpTransport);
            Calendar service = new Calendar.Builder(httpTransport, JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();

            Events events = service.events().list("primary").execute();
            return Map.of("items", events.getItems());
        } catch (GeneralSecurityException | IOException ex) {
            return Collections.singletonMap("error", "Unable to fetch calendar events");
        }
    }
}

