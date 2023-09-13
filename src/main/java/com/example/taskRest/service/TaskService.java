package com.example.taskRest.service;

import com.example.taskRest.data.entity.Task;
import com.example.taskRest.data.repository.TaskRepository;
import com.example.taskRest.data.repository.CustomerRepository;
import com.example.taskRest.dto.TaskDto;
import com.example.taskRest.service.mapper.TaskServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskService extends AbstractBusinessService<Task,Long, TaskDto, TaskRepository, TaskServiceMapper>{

    private final CustomerRepository customerRepository;

    @Autowired
    public TaskService(TaskRepository repository, TaskServiceMapper serviceMapper, CustomerRepository customerRepository) {
        super(repository, serviceMapper);
        this.customerRepository = customerRepository;
    }

    @Override
    public TaskDto save(TaskDto taskDto) {

        final Task entity = getServiceMapper().toEntity(taskDto);
        entity.setCustomer(this.customerRepository.findById(taskDto.getIdCustomer())
                .orElseThrow(() -> new RuntimeException(String.format("The user %s does not exist", taskDto.getIdCustomer()))));
        final Task savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }
}
