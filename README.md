# 🚀 Curso Spring Boot – Arquitectura de Software · EAFIT

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://openjdk.org/projects/jdk/17/)
[![Maven](https://img.shields.io/badge/Maven-3.9-blue?logo=apachemaven)](https://maven.apache.org/)
[![H2 Database](https://img.shields.io/badge/H2-in--memory-lightblue)](https://www.h2database.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build](https://img.shields.io/badge/build-passing-brightgreen)](#)

Proyecto de ejemplo para el curso de **Arquitectura de Software** de la Universidad EAFIT.  
Aprenderás a construir una API REST completa usando el stack más popular del ecosistema Java:
**Spring Boot · Spring Data JPA · Bean Validation · Spring Actuator · Lombok**.

---

## 📑 Tabla de contenidos

- [¿Qué aprenderás?](#-qué-aprenderás)
- [Tecnologías](#-tecnologías)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Cómo ejecutar el proyecto](#-cómo-ejecutar-el-proyecto)
- [Endpoints disponibles](#-endpoints-disponibles)
- [Conceptos clave explicados](#-conceptos-clave-explicados)
  - [¿Qué es Spring Boot?](#qué-es-spring-boot)
  - [Arquitectura MVC](#arquitectura-mvc)
  - [Anotaciones importantes](#anotaciones-importantes)
  - [Spring Data JPA](#spring-data-jpa)
  - [Bean Validation](#bean-validation)
  - [Spring Actuator](#spring-actuator)
  - [Lombok](#lombok)
- [Cómo ejecutar las pruebas](#-cómo-ejecutar-las-pruebas)
- [Configuración de la base de datos](#-configuración-de-la-base-de-datos)
- [Ejercicios propuestos](#-ejercicios-propuestos)
- [Recursos adicionales](#-recursos-adicionales)

---

## 🎯 ¿Qué aprenderás?

Al completar este proyecto podrás:

- ✅ Crear una API REST con Spring Boot desde cero
- ✅ Diseñar un controlador MVC con `@RestController`
- ✅ Persistir datos con **Spring Data JPA** y H2
- ✅ Validar entradas del usuario con **Bean Validation (JSR-380)**
- ✅ Monitorear tu aplicación con **Spring Actuator**
- ✅ Reducir código repetitivo con **Lombok**
- ✅ Escribir pruebas de integración con **MockMvc**

---

## 🛠 Tecnologías

| Tecnología | Versión | Descripción |
|---|---|---|
| **Java** | 17 LTS | Lenguaje de programación |
| **Spring Boot** | 3.5.3 | Framework principal |
| **Spring Web MVC** | (incluido en Boot) | Controladores REST |
| **Spring Data JPA** | (incluido en Boot) | Acceso a base de datos |
| **Hibernate** | 6.x | Implementación JPA |
| **H2 Database** | 2.x | Base de datos en memoria |
| **Bean Validation** | 3.x (JSR-380) | Validación de datos |
| **Spring Actuator** | (incluido en Boot) | Monitoreo y métricas |
| **Lombok** | 1.18.x | Reducción de boilerplate |
| **Maven** | 3.9+ | Gestión de dependencias |

---

## 📂 Estructura del proyecto

```
cursoSpringBoot/
├── src/
│   ├── main/
│   │   ├── java/cursoSpringBoot/
│   │   │   ├── CursoSpringBootApplication.java   ← Punto de entrada
│   │   │   ├── controllers/
│   │   │   │   ├── HelloWorldRestController.java  ← Ejemplo básico
│   │   │   │   ├── GreetingRestController.java    ← PathVariable
│   │   │   │   └── ProductRestController.java     ← CRUD completo
│   │   │   ├── models/
│   │   │   │   └── Product.java                  ← Entidad JPA + Lombok
│   │   │   └── repositories/
│   │   │       └── ProductRepository.java         ← Spring Data JPA
│   │   └── resources/
│   │       └── application.properties             ← Configuración
│   └── test/
│       └── java/cursoSpringBoot/
│           ├── CursoSpringBootApplicationTests.java
│           └── controllers/
│               ├── HelloWorldRestControllerTest.java
│               ├── GreetingRestControllerTest.java
│               └── ProductRestControllerTest.java
└── pom.xml                                        ← Dependencias Maven
```

---

## ▶ Cómo ejecutar el proyecto

### Pre-requisitos

- **Java 17** o superior ([Descargar Temurin 17](https://adoptium.net/))
- **Maven 3.9+** (o usa el wrapper incluido `./mvnw`)
- Un IDE como **IntelliJ IDEA**, **Eclipse** o **VS Code** con extensión Java

### Pasos

```bash
# 1. Clona el repositorio
git clone https://github.com/seagomezar/cursoSpringBoot.git
cd cursoSpringBoot

# 2. Compila y ejecuta (usa el Maven Wrapper incluido)
./mvnw spring-boot:run

# En Windows:
mvnw.cmd spring-boot:run
```

La aplicación estará disponible en: **http://localhost:8080**

---

## 🌐 Endpoints disponibles

### Endpoints básicos

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/clientes` | Retorna mensaje de bienvenida |
| `GET` | `/Testing` | Retorna mensaje de bienvenida (alias) |
| `GET` | `/saludar/{name}` | Saluda con el nombre enviado |

**Ejemplo:**
```
GET http://localhost:8080/saludar/Sebastian
→ HOLA Sebastian
```

### CRUD de Productos

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/api/productos` | Lista todos los productos |
| `GET` | `/api/productos/{id}` | Obtiene un producto por ID |
| `POST` | `/api/productos` | Crea un nuevo producto |
| `PUT` | `/api/productos/{id}` | Actualiza un producto |
| `DELETE` | `/api/productos/{id}` | Elimina un producto |

**Ejemplo – Crear producto:**
```bash
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{"name": "Laptop", "price": 999.99}'
```

**Respuesta:**
```json
{
  "id": 1,
  "name": "Laptop",
  "price": 999.99
}
```

### Actuator (Monitoreo)

| URL | Descripción |
|-----|-------------|
| `GET /actuator/health` | Estado de salud de la aplicación |
| `GET /actuator/info` | Información de la aplicación |
| `GET /actuator/metrics` | Métricas del sistema |

### Consola H2 (Base de datos)

Accede a **http://localhost:8080/h2-console**  
- JDBC URL: `jdbc:h2:mem:cursodb`  
- Usuario: `sa`  
- Contraseña: *(vacía)*

---

## 📚 Conceptos clave explicados

### ¿Qué es Spring Boot?

Spring Boot es un framework que simplifica la creación de aplicaciones Java listas para producción.
Su filosofía es **"Convention over Configuration"** (convención sobre configuración):
en lugar de escribir cientos de líneas de XML, usas **anotaciones** y Spring Boot
auto-configura todo lo necesario.

```java
@SpringBootApplication   // = @Configuration + @EnableAutoConfiguration + @ComponentScan
public class CursoSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(CursoSpringBootApplication.class, args);
    }
}
```

---

### Arquitectura MVC

Spring Boot sigue el patrón **Model–View–Controller**:

```
Cliente (navegador/Postman)
        │
        ▼  HTTP Request
  ┌─────────────┐
  │  Controller  │  ← @RestController  (recibe la petición)
  └──────┬──────┘
         │ llama
         ▼
  ┌─────────────┐
  │   Service   │  ← @Service         (lógica de negocio)
  └──────┬──────┘
         │ usa
         ▼
  ┌─────────────┐
  │ Repository  │  ← @Repository      (acceso a BD)
  └──────┬──────┘
         │ lee/escribe
         ▼
  ┌─────────────┐
  │    Model    │  ← @Entity          (datos)
  └─────────────┘
```

En este proyecto el `ProductRestController` llama directamente al `ProductRepository`
para mantener el ejemplo simple. En proyectos reales se añade una capa de **Service**.

---

### Anotaciones importantes

```java
// Declara un controlador REST (responde JSON/XML)
@RestController

// Mapea una URL a nivel de clase
@RequestMapping("/api/productos")

// Métodos HTTP individuales
@GetMapping        // GET
@PostMapping       // POST
@PutMapping        // PUT
@DeleteMapping     // DELETE

// Variables en la URL: /saludar/{name}
@PathVariable String name

// Deserializa el body JSON → objeto Java
@RequestBody Product product

// Activa Bean Validation en el body
@Valid @RequestBody Product product
```

---

### Spring Data JPA

JPA (Java Persistence API) es el estándar para mapear objetos Java a tablas de una base de datos relacional.
**Hibernate** es la implementación más popular, y **Spring Data JPA** lo simplifica aún más.

**Paso 1 – Define tu entidad:**
```java
@Entity                      // "Esta clase es una tabla de la BD"
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;         // Clave primaria auto-incremental

    private String name;
    private Double price;
}
```

**Paso 2 – Crea el repositorio:**
```java
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring genera automáticamente: save(), findById(), findAll(), deleteById()...
    // También puedes añadir métodos personalizados:
    List<Product> findByName(String name);
}
```

**Paso 3 – Úsalo en el controlador:**
```java
@Autowired
private ProductRepository productRepository;

List<Product> todos = productRepository.findAll();
Optional<Product> uno = productRepository.findById(1L);
Product nuevo = productRepository.save(new Product("Laptop", 999.0));
productRepository.deleteById(1L);
```

---

### Bean Validation

La validación de datos de entrada es **crucial** para la seguridad y calidad del software.

```java
@Entity
public class Product {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
    private Double price;
}
```

**Anotaciones de validación más usadas:**

| Anotación | Descripción |
|-----------|-------------|
| `@NotNull` | El campo no puede ser `null` |
| `@NotBlank` | El String no puede ser `null` ni vacío |
| `@NotEmpty` | La colección no puede ser `null` ni vacía |
| `@Min(n)` | Valor numérico mínimo |
| `@Max(n)` | Valor numérico máximo |
| `@DecimalMin(n)` | Valor decimal mínimo |
| `@Size(min, max)` | Tamaño de String o colección |
| `@Email` | Formato de correo electrónico |
| `@Pattern(regexp)` | Expresión regular |

Para activar la validación en el controlador, añade `@Valid`:
```java
@PostMapping
public ResponseEntity<Product> crear(@Valid @RequestBody Product product) { ... }
```

---

### Spring Actuator

Spring Actuator expone endpoints HTTP para monitorear tu aplicación en producción.

```
GET /actuator/health   → {"status": "UP"}
GET /actuator/info     → {"app": {"name": "Curso Spring Boot", ...}}
GET /actuator/metrics  → lista de métricas disponibles
```

**Configuración en `application.properties`:**
```properties
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always
```

---

### Lombok

Lombok es una librería que genera código en tiempo de compilación para eliminar boilerplate.

```java
@Data           // genera getters, setters, equals, hashCode, toString
@Builder        // patrón Builder: Product.builder().name("x").price(1.0).build()
@NoArgsConstructor   // constructor vacío
@AllArgsConstructor  // constructor con todos los campos
public class Product { ... }
```

**Sin Lombok** necesitarías escribir ~50 líneas de código. **Con Lombok**, 4 anotaciones.

---

## 🧪 Cómo ejecutar las pruebas

```bash
# Ejecutar todas las pruebas
./mvnw test

# Ejecutar una clase de prueba específica
./mvnw test -Dtest=ProductRestControllerTest

# Ejecutar y ver el reporte en target/surefire-reports/
./mvnw test && open target/surefire-reports/index.html
```

Las pruebas utilizan `MockMvc` que simula peticiones HTTP **sin levantar un servidor real**,
lo que las hace rápidas y confiables:

```java
@SpringBootTest
@AutoConfigureMockMvc
class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void crear_shouldPersistAndReturnProduct() throws Exception {
        mockMvc.perform(post("/api/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Laptop\",\"price\":999.99}"))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("Laptop"));
    }
}
```

---

## ⚙ Configuración de la base de datos

El proyecto usa **H2**, una base de datos embebida en memoria perfecta para desarrollo y pruebas.  
En un proyecto real reemplazarías H2 por PostgreSQL o MySQL:

```properties
# application.properties para PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/mi_base_de_datos
spring.datasource.username=mi_usuario
spring.datasource.password=mi_contraseña
spring.jpa.hibernate.ddl-auto=update
```

Y agregarías la dependencia en `pom.xml`:
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

## 💡 Ejercicios propuestos

Los siguientes ejercicios están ordenados por dificultad para ayudarte a consolidar lo aprendido:

### Nivel 1 – Básico
1. Agrega un endpoint `GET /api/productos/count` que retorne el número total de productos.
2. Agrega el campo `description` (String, opcional) a la entidad `Product`.
3. Agrega una validación para que el `price` no supere `99999.99`.

### Nivel 2 – Intermedio
4. Crea una entidad `Category` (id, name) y agrega una relación `@ManyToOne` en `Product`.
5. Agrega un método en el repositorio `findByName(String name)` y expónlo en el controlador.
6. Crea una capa de servicio `ProductService` entre el controlador y el repositorio.

### Nivel 3 – Avanzado
7. Implementa paginación en `GET /api/productos` usando `Pageable`.
8. Agrega manejo global de excepciones con `@ControllerAdvice`.
9. Conecta el proyecto a una base de datos PostgreSQL con Docker Compose.
10. Agrega documentación automática con **Springdoc OpenAPI** (Swagger UI).

---

## 📖 Recursos adicionales

| Recurso | Enlace |
|---------|--------|
| Documentación oficial Spring Boot | https://spring.io/projects/spring-boot |
| Spring Initializr (generador de proyectos) | https://start.spring.io |
| Guía de Spring Data JPA | https://spring.io/guides/gs/accessing-data-jpa/ |
| Referencia de Bean Validation | https://beanvalidation.org/2.0/spec/ |
| Documentación de Lombok | https://projectlombok.org/features/ |
| Baeldung (tutoriales en inglés) | https://www.baeldung.com/spring-boot |

---

## 👨‍🏫 Autor

**Sebastian Gomez** – [@seagomezar](https://github.com/seagomezar)  
Universidad EAFIT · Curso de Arquitectura de Software

---

## 📄 Licencia

Este proyecto está bajo la licencia [MIT](https://opensource.org/licenses/MIT).  
Puedes usarlo libremente para aprender, modificar y distribuir con fines educativos.
