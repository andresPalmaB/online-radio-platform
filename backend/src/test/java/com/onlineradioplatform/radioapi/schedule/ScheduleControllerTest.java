package com.onlineradioplatform.radioapi.schedule;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScheduleControllerTest {

    @Test
    void shouldReturnWeeklySchedule() {
        // Arrange
        ScheduleController controller = new ScheduleController();

        // Act
        List<ScheduleResponse> response = controller.getSchedule();

        // Assert
        assertEquals(6, response.size());
        ScheduleResponse firstEntry = response.getFirst();
        assertEquals(1L, firstEntry.scheduleId());
        assertEquals(1L, firstEntry.programId());
        assertEquals(DayOfWeek.MONDAY, firstEntry.dayOfWeek());
        assertEquals(LocalTime.of(8, 0), firstEntry.startTime());
        assertEquals(firstEntry.programId(), response.get(1).programId());
    }
}
