package com.example.demo.l6;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @PostMapping("/l6/register")
    public String registerUser(@Valid @RequestBody RegistrationDTO request) {
        return "Регистрация успешна! Пользователь: " + request.getUsername()
                + ", Email: " + request.getEmail();
    }
}
