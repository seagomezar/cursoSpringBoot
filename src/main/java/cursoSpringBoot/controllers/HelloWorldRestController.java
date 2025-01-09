package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping({"/clientes", "/Testing"})
    public String HellowWorld() {
        return "Welcome to my course";
    }

}
