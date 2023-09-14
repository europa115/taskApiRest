package com.example.taskRest.rest.controller;

import com.example.taskRest.data.entity.Task;
import com.example.taskRest.dto.TaskDto;
import com.example.taskRest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskDto>> listTasks() {

        List<Task> tasks = taskService.getRepository().findAll();
        List<TaskDto> taskDtos = taskService.getServiceMapper().toDto(tasks);
        return ResponseEntity.ok(taskDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {

        Optional<Task> taskOptional = taskService.getRepository().findById(id);
        return taskOptional.map(task -> ResponseEntity.ok(taskService.getServiceMapper().toDto(task)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {

        TaskDto newTask = taskService.save(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @PutMapping("/agree/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {

        if (!taskService.getRepository().existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        TaskDto updatedTask = taskService.save(taskDto);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        if (!taskService.getRepository().existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskService.getRepository().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}