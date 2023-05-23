package com.example.demo.service;

import com.example.demo.entity.employee;
import com.example.demo.repository.employeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {
    @Autowired
    private employeeRepository repository;

    public employee saveEmployee(employee emp){
        return repository.save(emp);
    }

    public employeeResponse<List<employee>> getEmployees(){
        List<employee> employees = repository.findAll();
        int count = employees.size();

        employeeResponse<List<employee>> response = new employeeResponse<List<employee>>();
        response.setCount(count);
        response.setEmployees(employees);

        return response;
    }

    public employeeResponse<Page<employee>> getEmployeesByPage(int offset, int pageSize) {
        Page<employee> employees = repository.findAll(PageRequest.of(offset, pageSize));
        int count = employees.getSize();

        employeeResponse<Page<employee>> response = new employeeResponse<Page<employee>>();
        response.setCount(count);
        response.setEmployees(employees);

        return response;
    }

    public employee getEmployee(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteEmployee(int id){
        employee toBeDeleted =  repository.findById(id).orElse(null);
        repository.deleteById(id);
        return toBeDeleted.toString()+"\n\nwas deleted!!!";
    }

    public employee updateEmployee(employee emp){
        employee existing = repository.findById(emp.getId()).orElse(null);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(emp, existing);

        return repository.save(existing);
    }
}
