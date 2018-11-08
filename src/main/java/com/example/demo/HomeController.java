package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    /*@RequestMapping("/")
    public String showDepartmentAndEmployee(Model model){


        model.addAttribute("departments", departmentRepository.findAll());
        return "index";

    }*/

    @GetMapping("/adddepartment")
    public String addDepartment(Model model){
        model.addAttribute("department", new Department());
        return "adddepartment";
    }

    @PostMapping("/adddepartment")
    public String saveDepartemnt(@ModelAttribute("department") Department department){
        departmentRepository.save(department);
        return "redirect:/";
    }

    @GetMapping("/addemployee")
    public String addEmployee(HttpServletRequest request, Model model){
        Employee employee = new Employee();

        if(request.getParameter("departementid")!=null){
            long departementid = new Long(request.getParameter("employeeid"));
            employee.setDepartment(departmentRepository.findById(departementid).get());
        }


//        employeeRepository.findById(employeeId).get();

        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentRepository.findAll());
        return "addemployee";
    }

    @PostMapping("/addemployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model){
        Set<Employee> employees = new HashSet<>();
        employeeRepository.save(employee);
        return "redirect:/";
    }
    /*@RequestMapping("/json")
    public @ResponseBody String admin(){
        return "This is an admin page, where the json will be shown";
    }*/

    @RequestMapping("/api/employees")
    public @ResponseBody String apiuser(){
        return "This is an apiuser employee page";
    }

    @RequestMapping("/api/departments")
    public @ResponseBody String apiuserDep(){
        return "This is an api user department page";
    }
}

