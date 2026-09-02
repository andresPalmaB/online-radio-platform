package com.onlineradioplatform.radioapi.schedule;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ScheduleControllerTest {

    @Test
    void shouldReturnWeeklySchedule() {
        // Arrange
        ScheduleService scheduleService = mock(ScheduleService.class);

        List<ScheduleResponse> expectedSchedule = List.of(
                new ScheduleResponse(
                        1L,
                        1L,
                        "Oración de la mañana",
                        "Antonio Bustos",
                        DayOfWeek.MONDAY,
                        LocalTime.of(8, 0)
                )
        );

        when(scheduleService.getSchedule()).thenReturn(expectedSchedule);

        ScheduleController controller =
                new ScheduleController(scheduleService);

        // Act
        List<ScheduleResponse> response = controller.getSchedule();

        // Assert
        assertEquals(expectedSchedule, response);
        verify(scheduleService).getSchedule();
    }
}
