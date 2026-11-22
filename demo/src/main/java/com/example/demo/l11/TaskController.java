package com.example.demo.l11;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController("l11TaskController")
@RequestMapping("/l11/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Page<TaskEntity> getTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return taskService.getTasks(page, size, sortBy);
    }

    @PostMapping
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return taskService.createTask(task);
    }
}