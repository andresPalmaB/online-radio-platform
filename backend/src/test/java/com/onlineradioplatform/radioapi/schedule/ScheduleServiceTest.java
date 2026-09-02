package com.onlineradioplatform.radioapi.schedule;

import com.onlineradioplatform.radioapi.program.Program;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ScheduleServiceTest {

    @Test
    void shouldReturnScheduleResponses() {
        // Arrange
        ScheduleEntryRepository repository =
                mock(ScheduleEntryRepository.class);

        Program program = mock(Program.class);
        ScheduleEntry scheduleEntry = mock(ScheduleEntry.class);

        when(program.getId()).thenReturn(1L);
        when(program.getName()).thenReturn("Oración de la mañana");
        when(program.getPresenter()).thenReturn("Antonio Bustos");

        when(scheduleEntry.getId()).thenReturn(1L);
        when(scheduleEntry.getProgram()).thenReturn(program);
        when(scheduleEntry.getDayOfWeek()).thenReturn(DayOfWeek.MONDAY);
        when(scheduleEntry.getStartTime()).thenReturn(LocalTime.of(8, 0));

        when(repository.findAll()).thenReturn(List.of(scheduleEntry));

        ScheduleService service = new ScheduleService(repository);

        // Act
        List<ScheduleResponse> responses = service.getSchedule();

        // Assert
        assertEquals(1, responses.size());

        ScheduleResponse response = responses.getFirst();

        assertEquals(1L, response.scheduleId());
        assertEquals(1L, response.programId());
        assertEquals("Oración de la mañana", response.programName());
        assertEquals("Antonio Bustos", response.presenter());
        assertEquals(DayOfWeek.MONDAY, response.dayOfWeek());
        assertEquals(LocalTime.of(8, 0), response.startTime());

        verify(repository).findAll();
    }
}
