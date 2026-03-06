package cursoSpringBoot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests de integración para {@link HelloWorldRestController}.
 *
 * <p>Utiliza {@link MockMvc} para simular peticiones HTTP sin levantar
 * un servidor real, lo que hace los tests más rápidos.
 */
@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getClientes_shouldReturn200AndWelcomeMessage() throws Exception {
        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to my course"));
    }

    @Test
    void getTesting_shouldReturn200AndWelcomeMessage() throws Exception {
        mockMvc.perform(get("/Testing"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to my course"));
    }
}
