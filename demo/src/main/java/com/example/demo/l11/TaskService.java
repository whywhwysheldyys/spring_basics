package com.example.demo.l11;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Page<TaskEntity> getTasks(int page, int size, String sortBy) {

        Sort sort = Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return taskRepository.findAll(pageable);
    }

    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }
}
