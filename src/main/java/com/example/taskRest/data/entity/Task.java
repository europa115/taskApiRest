package com.example.taskRest.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "NAME", nullable = false)
    String name;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "COMPLETED", nullable = false)
    boolean completed;
    @ManyToOne
    private Customer customer;
}
