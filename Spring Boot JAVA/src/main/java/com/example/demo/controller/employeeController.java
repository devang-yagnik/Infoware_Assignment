package com.example.demo.controller;

import com.example.demo.entity.employee;
import com.example.demo.service.employeeResponse;
import com.example.demo.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class employeeController {
    @Autowired
    private employeeService service;

    @PostMapping("/addEmployee")
    public employee addEmployee(@RequestBody employee emp){
        return service.saveEmployee(emp);
    }

    @GetMapping("/getEmployees")
    public employeeResponse<List<employee>> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/getEmployees/{offset}/{pageSize}")
    public employeeResponse<Page<employee>> getEmployeesByPage(@PathVariable int offset, @PathVariable int pageSize) {
        return service.getEmployeesByPage(offset, pageSize);
    }

    @GetMapping("/getEmployee/{id}")
    public employee getEmployee(@PathVariable int id){
        return service.getEmployee(id);
    }

    @PutMapping("/updateEmployee")
    public employee updateEmployee(@RequestBody employee emp){
        return service.updateEmployee(emp);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }
}
