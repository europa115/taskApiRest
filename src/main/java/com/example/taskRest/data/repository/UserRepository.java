package com.example.taskRest.data.repository;

import com.example.taskRest.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Long> {
}
