package com.example.taskRest.service.mapper;

import com.example.taskRest.data.entity.Task;
import com.example.taskRest.dto.TaskDto;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceMapper extends AbstractServiceMapper<Task, TaskDto> {


    @Override
    public Task toEntity(TaskDto taskDto) {

        final Task entity = new Task();
        entity.setId(taskDto.getId());
        entity.setName(taskDto.getName());
        entity.setDescription(taskDto.getDescription());
        entity.setCompleted(taskDto.isCompleted());

        return entity;
    }

    @Override
    public TaskDto toDto(Task task) {

        final TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());
        //dto.setIdCustomer(task.getCustomer().getId());

        return dto;
    }
}
