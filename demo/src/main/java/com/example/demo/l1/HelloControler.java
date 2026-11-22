package com.example.demo.l1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @GetMapping("/l1/hello")
    public String sayHello() {
        return "Привет! Мой первый Spring Boot проект работает на Java 25!";
    }

    @GetMapping("/l1/greet/{name}") // делаем эндпоинт greet, и динамическую переменную name
    public String greetUser(@PathVariable String name) { // преобразуем ее в url
        return "Привет, " + name + "! Рад тебя видеть."; // вывод
    }

    @GetMapping("/l1/search") // ловим запросы идущие на эндпоинт search
    public String search(@RequestParam String keyword) { // аннотация преобразует все что стоит после =
        return "Ты искал следующее слово: " + keyword; // вывод
    }

    @GetMapping("/l1/calc")
    public int calc(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/l1/calcTextOutput")
    public String calcText(@RequestParam int a, @RequestParam int b) {
        int sum = a + b;
        return "Результат сложения: " + a + " и " + b + " = " + sum;
    }
}
