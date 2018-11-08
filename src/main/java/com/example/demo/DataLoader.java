package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... strings) throws Exception{
        //creating  anew department
        Department department = new Department();
        department.setName("Accounting");

        //creating a new employee
        Employee employee = new Employee();
        employee.setName("Lee");
        employee.setJobTitle("Accountant");
        Set<Employee> employees = new HashSet<>();
        employees.add(employee);

        employee.setName("Hanna");
        employee.setJobTitle("Data Clerk");
        employee.setDepartment(department);
        employees.add(employee);

        //setting th eemployees to the department
        department.setEmployees(employees);

        departmentRepository.save(department);

        Department department1 = new Department();
        department1.setName("IT");
        Employee employee1 = new Employee();
        employee1.setName("John");
        employee1.setJobTitle("Analyst");
        employee1.setDepartment(department1);
        employees  = new HashSet<>();
        employees.add(employee1);
        department1.setEmployees(employees);
        departmentRepository.save(department1);
    }
}
