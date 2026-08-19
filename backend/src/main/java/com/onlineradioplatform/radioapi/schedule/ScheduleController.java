package com.onlineradioplatform.radioapi.schedule;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "http://localhost:5173")
public class ScheduleController {

    @GetMapping
    public List<ScheduleResponse> getSchedule() {
        return List.of(
                new ScheduleResponse(
                        1,
                        1,
                        "Oración de la Mañana",
                        "Antonio Bustos",
                        DayOfWeek.MONDAY,
                        LocalTime.of(8, 0)
                ),
                new ScheduleResponse(
                        2,
                        1,
                        "Oración de la Mañana",
                        "Antonio Bustos",
                        DayOfWeek.WEDNESDAY,
                        LocalTime.of(8, 0)
                ),
                new ScheduleResponse(
                        3,
                        1,
                        "Oración de la Mañana",
                        "Antonio Bustos",
                        DayOfWeek.FRIDAY,
                        LocalTime.of(8, 0)
                ),
                new ScheduleResponse(
                        4,
                        2,
                        "Ezequiel 7:23",
                        "Antonio Bustos",
                        DayOfWeek.TUESDAY,
                        LocalTime.of(14, 0)
                ),
                new ScheduleResponse(
                        5,
                        2,
                        "Ezequiel 7:23",
                        "Antonio Bustos",
                        DayOfWeek.THURSDAY,
                        LocalTime.of(14, 0)
                ),
                new ScheduleResponse(
                        6,
                        3,
                        "Reflexión de la noche",
                        "Radio Team",
                        DayOfWeek.SUNDAY,
                        LocalTime.of(19, 0)
                )
        );
    }
}
