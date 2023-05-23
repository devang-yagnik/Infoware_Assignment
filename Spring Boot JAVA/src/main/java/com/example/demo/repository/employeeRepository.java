package com.example.demo.repository;

import com.example.demo.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<employee, Integer> {

}
