package cursoSpringBoot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests de integración para {@link GreetingRestController}.
 */
@SpringBootTest
@AutoConfigureMockMvc
class GreetingRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saludar_shouldReturnGreetingWithName() throws Exception {
        mockMvc.perform(get("/saludar/Sebastian"))
                .andExpect(status().isOk())
                .andExpect(content().string("HOLA Sebastian"));
    }

    @Test
    void saludar_shouldHandleMultipleNames() throws Exception {
        mockMvc.perform(get("/saludar/Mundo"))
                .andExpect(status().isOk())
                .andExpect(content().string("HOLA Mundo"));
    }
}
