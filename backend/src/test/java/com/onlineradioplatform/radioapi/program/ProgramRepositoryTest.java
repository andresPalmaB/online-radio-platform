package com.onlineradioplatform.radioapi.program;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ProgramRepositoryTest {

    private final ProgramRepository repository;

    @Autowired
    ProgramRepositoryTest(ProgramRepository repository) {
        this.repository = repository;
    }

    @Test
    void shouldSaveProgram() {

        Program program = new Program("Oración de la mañana", "Antonio Bustos");

        Program savedProgram = repository.saveAndFlush(program);

        assertNotNull(savedProgram.getId());
        assertEquals("Oración de la mañana", savedProgram.getName());
        assertEquals("Antonio Bustos", savedProgram.getPresenter());
        assertEquals(1L, repository.count());

    }
}
