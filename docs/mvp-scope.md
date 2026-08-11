# MVP Scope

## Product overview

Online Radio Platform is a reusable and customizable platform for online radio stations. Each customer will have a separate installation with their own website, database, branding, music library, and administration accounts.

## Must-have features

- Continuous audio streaming through AzuraCast.
- Automatic music playback using AzuraCast AutoDJ.
- Live programs broadcast through RadioBOSS.
- A single audio player for music and live programs.
- Play, pause, and volume controls.
- Current song or program information.
- Weekly program schedule.
- Responsive design for desktop and mobile devices.
- Administration area for managing programs and schedules.
- Basic branding customization:
  - Station name and slogan.
  - Logo.
  - Primary color.
  - Background color.
  - Text color.

## Features excluded from the MVP

- Listener accounts.
- Live chat.
- Donations.
- Podcasts.
- Push notifications.
- Multiple stations in one installation.
- Advanced layout, font, animation, or custom CSS settings.

## Technical components

- React and TypeScript for the user interface.
- Spring Boot for the REST API and business rules.
- PostgreSQL for structured application data.
- AzuraCast for music management and audio streaming.
- RadioBOSS for producing and sending live programs.
- Nginx as the public entry point.
- Docker for containerized services.
- Ubuntu VPS for hosting the platform.

## Success criteria

The MVP is successful when visitors can listen to continuous music and live programs, view information about the current broadcast, consult the weekly schedule, and use the website correctly on desktop and mobile devices. Administrators must be able to manage the schedule and basic station branding.