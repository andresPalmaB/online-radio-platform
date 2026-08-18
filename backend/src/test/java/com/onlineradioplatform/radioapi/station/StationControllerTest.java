package com.onlineradioplatform.radioapi.station;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StationControllerTest {

    @Test
    void shouldReturnStationInformation() {
        StationController controller = new StationController();

        StationResponse answer = controller.getStation();

        assertEquals("En el altar de Dios", answer.name());
        assertEquals("Una voz en el altar, siempre", answer.slogan());
    }
}
