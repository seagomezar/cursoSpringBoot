package cursoSpringBoot.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import cursoSpringBoot.models.Product;
import cursoSpringBoot.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests de integración para {@link ProductRestController}.
 *
 * <p>Cubre: listar, obtener, crear, actualizar y eliminar productos.
 */
@SpringBootTest
@AutoConfigureMockMvc
class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Test
    void listar_shouldReturnEmptyListInitially() throws Exception {
        mockMvc.perform(get("/api/productos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void crear_shouldPersistAndReturnProduct() throws Exception {
        Product product = Product.builder().name("Laptop").price(999.99).build();

        mockMvc.perform(post("/api/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(999.99));
    }

    @Test
    void crear_shouldReturn400WhenNameIsBlank() throws Exception {
        Product invalid = Product.builder().name("").price(10.0).build();

        mockMvc.perform(post("/api/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalid)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void obtener_shouldReturn404WhenNotFound() throws Exception {
        mockMvc.perform(get("/api/productos/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void actualizar_shouldModifyExistingProduct() throws Exception {
        Product saved = productRepository.save(
                Product.builder().name("Mouse").price(25.0).build());

        Product updated = Product.builder().name("Mouse Inalámbrico").price(35.0).build();

        mockMvc.perform(put("/api/productos/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mouse Inalámbrico"))
                .andExpect(jsonPath("$.price").value(35.0));
    }

    @Test
    void eliminar_shouldReturn204WhenDeleted() throws Exception {
        Product saved = productRepository.save(
                Product.builder().name("Teclado").price(50.0).build());

        mockMvc.perform(delete("/api/productos/" + saved.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    void eliminar_shouldReturn404WhenNotFound() throws Exception {
        mockMvc.perform(delete("/api/productos/999"))
                .andExpect(status().isNotFound());
    }
}
