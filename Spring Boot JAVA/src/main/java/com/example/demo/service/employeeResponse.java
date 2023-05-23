package com.example.demo.service;

import com.example.demo.entity.employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class employeeResponse<T> {
    private int count;
    private T employees;
}
