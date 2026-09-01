package com.onlineradioplatform.radioapi.schedule;

import com.onlineradioplatform.radioapi.program.Program;
import com.onlineradioplatform.radioapi.program.ProgramRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ScheduleEntryRepositoryTest {

    private final ScheduleEntryRepository scheduleEntryRepository;
    private final ProgramRepository programRepository;

    @Autowired
    ScheduleEntryRepositoryTest(ScheduleEntryRepository repository, ProgramRepository programRepository) {
        this.scheduleEntryRepository = repository;
        this.programRepository = programRepository;
    }

    @Test
    void shouldSaveScheduleEntry() {

        Program program = new Program("Oración de la mañana", "Antonio Bustos");
        Program savedProgram = programRepository.saveAndFlush(program);

        ScheduleEntry scheduleEntry = new ScheduleEntry(savedProgram, DayOfWeek.MONDAY, LocalTime.of(8, 0));
        ScheduleEntry savedScheduleEntry = scheduleEntryRepository.saveAndFlush(scheduleEntry);

        assertNotNull(savedScheduleEntry.getId());
        assertEquals(DayOfWeek.MONDAY, savedScheduleEntry.getDayOfWeek());
        assertEquals(LocalTime.of(8, 0), savedScheduleEntry.getStartTime());
        assertEquals(savedProgram.getId(), savedScheduleEntry.getProgram().getId());
        assertEquals(1L, scheduleEntryRepository.count());
    }
}
