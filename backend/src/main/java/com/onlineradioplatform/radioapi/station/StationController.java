package com.onlineradioplatform.radioapi.station;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/station")
public class StationController {

    @GetMapping
    public StationResponse getStation() {
        return new StationResponse(
                "En el altar de Dios",
                "Una voz en el altar, siempre"
        );
    }
}
