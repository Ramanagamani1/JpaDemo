package com.example.jpademo.controllers;

import com.example.jpademo.dtos.CreateEmployeeRequestDto;
import com.example.jpademo.dtos.CreateEmployeeResponseDto;
import com.example.jpademo.models.Employee;
import com.example.jpademo.services.EmployeeService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employee")
    public CreateEmployeeResponseDto getEmployees() {
        return CreateEmployeeResponseDto.builder()
                .employees(employeeService.getAllEmployees())
                .build();
    }

    @GetMapping("/employee/{id}")
    public CreateEmployeeResponseDto getEmployee(@PathVariable("id") Integer id) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
        List<Employee> employeeList = existingEmployee.isPresent() ? Arrays.asList(existingEmployee.get()) : new ArrayList<>();
        return CreateEmployeeResponseDto.builder()
                .employees(employeeList)
                .build();
    }

    @PostMapping("/employee")
    public void createEmployee(@RequestBody @Valid CreateEmployeeRequestDto requestDto) {
        employeeService.createEmployee(requestDto.to());
    }

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam("id") Integer id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable("id") Integer id, @RequestBody CreateEmployeeRequestDto requestDto) {
        employeeService.updateEmployee(id, requestDto.to());
    }

    @GetMapping("/employee/params")
    public CreateEmployeeResponseDto getEmployees(@RequestParam("name") String name,
                                                  @RequestParam("age") Integer age,
                                                  @RequestParam("country") String country) {
        return CreateEmployeeResponseDto.builder()
                .employees(employeeService.get(name, age, country))
                .build();
    }
}
