package cursoSpringBoot.repositories;

import cursoSpringBoot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para {@link Product}.
 *
 * <p>Extiende {@link JpaRepository} lo que nos provee automáticamente:
 * save(), findById(), findAll(), deleteById(), count(), etc.
 *
 * <p>No necesitamos escribir ninguna implementación — Spring Data JPA
 * genera el código en tiempo de ejecución.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
