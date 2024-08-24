package io.github.pablitohaddad.restwithspringbootandjava;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController// Combination of ResponseBody and Controller;
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(); // Id mock

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name){ // parametros opcionais
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
