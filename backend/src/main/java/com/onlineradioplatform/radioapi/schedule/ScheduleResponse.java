package com.onlineradioplatform.radioapi.schedule;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record ScheduleResponse(
        long scheduleId,
        long programId,
        String programName,
        String presenter,
        DayOfWeek dayOfWeek,
        LocalTime startTime
) {
}
