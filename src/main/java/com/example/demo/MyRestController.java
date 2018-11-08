package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/json")
    public Iterable<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

}