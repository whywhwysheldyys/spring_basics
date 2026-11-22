package com.example.demo.l2;

import com.example.demo.l3.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @PostMapping("/l2/tasks")
    public String createTask(@RequestBody TaskDTO task) {
        return "Задача создана! Название: '" + task.getTitle() + "' , Приоритет: " + task.getPriority();
    }

    @PostMapping("/l2/user")
    public String createUser(@RequestBody UserDTO user) {
        return "Пользователь " + user.getUsername() + " успешно зарегистрирован. Возраст: " + user.getAge();
    }
}