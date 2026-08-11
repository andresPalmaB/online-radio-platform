# User Stories and Acceptance Criteria

## Visitor stories

### US-01: Listen to the radio stream

As a visitor, I want to listen to the station's continuous audio stream so that I can enjoy its music and live programs.

#### Acceptance criteria

- The visitor can start and pause the audio.
- The visitor can adjust the volume.
- The same player broadcasts both AutoDJ music and live programs.
- The stream continues when AzuraCast switches between AutoDJ and a live presenter.
- The player works on desktop and mobile devices.

### US-02: View the current broadcast

As a visitor, I want to see what is currently playing so that I can identify the song or live program.

#### Acceptance criteria

- The website displays the current song title and artist when AutoDJ is active.
- The website displays the live program information when a presenter is connected.
- The information updates without requiring the visitor to reload the page.

### US-03: View the weekly schedule

As a visitor, I want to view the weekly program schedule so that I know when each program will be broadcast.

#### Acceptance criteria

- The schedule displays the program name, presenter, day, start time, and end time.
- Programs are organized clearly by day.
- The schedule is readable on desktop and mobile devices.

## Administrator stories

### US-04: Manage programs

As an administrator, I want to manage radio programs so that the website displays accurate program information.

#### Acceptance criteria

- The administrator can create, view, edit, and delete programs.
- Each program includes a name, description, presenter, and optional image.
- Required fields are validated before saving.
- Changes are reflected on the public website.

### US-05: Manage the weekly schedule

As an administrator, I want to manage the weekly schedule so that visitors know when each program is broadcast.

#### Acceptance criteria

- The administrator can assign a program to a day, start time, and end time.
- The system prevents the end time from being earlier than the start time.
- The administrator can edit and delete scheduled broadcasts.
- Schedule changes are reflected on the public website.

### US-06: Customize station branding

As an administrator, I want to customize the station's branding so that the website reflects its visual identity.

#### Acceptance criteria

- The administrator can change the station name and slogan.
- The administrator can upload a logo.
- The administrator can select primary, background, and text colors.
- The system validates uploaded image types and sizes.
- The administrator can preview the branding changes.
- Saved changes are applied to the public website.