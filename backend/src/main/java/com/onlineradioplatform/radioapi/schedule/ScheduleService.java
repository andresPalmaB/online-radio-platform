package com.onlineradioplatform.radioapi.schedule;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleEntryRepository scheduleEntryRepository;

    public ScheduleService(
            ScheduleEntryRepository scheduleEntryRepository
    ) {
        this.scheduleEntryRepository = scheduleEntryRepository;
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> getSchedule() {
        return scheduleEntryRepository.findAll()
                .stream()
                .map(scheduleEntry -> new ScheduleResponse(
                        scheduleEntry.getId(),
                        scheduleEntry.getProgram().getId(),
                        scheduleEntry.getProgram().getName(),
                        scheduleEntry.getProgram().getPresenter(),
                        scheduleEntry.getDayOfWeek(),
                        scheduleEntry.getStartTime()
                ))
                .toList();
    }
}
