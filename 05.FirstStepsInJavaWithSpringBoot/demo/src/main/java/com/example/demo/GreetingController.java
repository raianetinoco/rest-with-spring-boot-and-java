package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController // retorna um objeto
public class GreetingController {
    private  static final String template = "Hello, %s!";
    private  static final AtomicLong counter = new AtomicLong(); // gera um id automatico
    @RequestMapping("/greeting") //mapeia uma requsição para um metodo e torna isso um endereço http
    public Greenting greenting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greenting(counter.incrementAndGet(), String.format(template, name)); // a cada chamada irá gerar um id automatico
    }
}
