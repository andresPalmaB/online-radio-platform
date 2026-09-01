package com.onlineradioplatform.radioapi.schedule;

import com.onlineradioplatform.radioapi.program.Program;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "schedule_entries")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false, length = 10)
    private DayOfWeek dayOfWeek;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    public ScheduleEntry(
            Program program,
            DayOfWeek dayOfWeek,
            LocalTime startTime
    ) {
        this.program = program;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
    }
}
