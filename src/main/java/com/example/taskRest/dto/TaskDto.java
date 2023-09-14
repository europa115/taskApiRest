package com.example.taskRest.dto;

import com.example.taskRest.data.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private boolean completed;
    //private Long idCustomer;
}

