package cursoSpringBoot.controllers;

import cursoSpringBoot.models.Product;
import cursoSpringBoot.repositories.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para demostrar un CRUD completo con Spring Boot.
 *
 * <p>Conceptos demostrados:
 * <ul>
 *   <li>{@link RestController} — combina @Controller + @ResponseBody</li>
 *   <li>{@link RequestMapping} — prefijo común para todos los endpoints</li>
 *   <li>{@link GetMapping}, {@link PostMapping}, {@link PutMapping}, {@link DeleteMapping}</li>
 *   <li>{@link PathVariable} — variables en la URL (/productos/{id})</li>
 *   <li>{@link RequestBody} — deserialización automática del JSON del body</li>
 *   <li>{@link Valid} — activa Bean Validation en el body recibido</li>
 *   <li>{@link ResponseEntity} — control total sobre el código HTTP de respuesta</li>
 * </ul>
 */
@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductRepository productRepository;

    /** Lista todos los productos — GET /api/productos */
    @GetMapping
    public List<Product> listar() {
        return productRepository.findAll();
    }

    /** Obtiene un producto por id — GET /api/productos/{id} */
    @GetMapping("/{id}")
    public ResponseEntity<Product> obtener(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** Crea un nuevo producto — POST /api/productos */
    @PostMapping
    public ResponseEntity<Product> crear(@Valid @RequestBody Product product) {
        Product saved = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /** Actualiza un producto existente — PUT /api/productos/{id} */
    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizar(@PathVariable Long id,
                                               @Valid @RequestBody Product product) {
        return productRepository.findById(id).map(existing -> {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            return ResponseEntity.ok(productRepository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    /** Elimina un producto — DELETE /api/productos/{id} */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
