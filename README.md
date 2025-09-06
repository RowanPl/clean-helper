# clean-helper

A self-hosted household planner that tracks the realistic effort of chores. The application learns how much "energy" each user spends on different tasks and suggests a weekly energy budget to avoid burnout.

## Features

- Calendar view with tasks and optional Google Calendar overlay (read-only).
- Per-user weekly energy budget that adapts over time.
- Task energy learning using recent history (median or EWMA).
- End-of-week reports highlighting over/under estimates.

- Session-based authentication with Spring Security.
- Calendar API endpoint to query tasks by date range.

- Spring Boot + SQLite backend; React frontend (planned).

## Building

```bash
mvn test
```

This will compile the Spring Boot backend and run the test suite (if present).

## Google OAuth Setup

To enable Google Calendar integration the application uses OAuth 2.0.
Create an OAuth consent screen and a desktop OAuth client ID in the
[Google Cloud Console](https://console.cloud.google.com/). Download the
client credentials JSON and point the application to it via the
`GOOGLE_CREDENTIALS_FILE` environment variable.
