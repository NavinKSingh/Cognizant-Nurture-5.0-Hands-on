package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /** GET /employees (doc 3 "Create REST service to gets all employees") */
    @GetMapping
    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("Start");
        ArrayList<Employee> employees = employeeService.getAllEmployees();
        LOGGER.info("End");
        return employees;
    }

    /**
     * PUT /employees (doc 4 "Implement REST service for updating an employee").
     * Validation errors (e.g. bad types in `id`) are handled centrally by
     * GlobalExceptionHandler.handleHttpMessageNotReadable, and bean
     * validation failures by handleMethodArgumentNotValid.
     */
    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        employeeService.updateEmployee(employee);
        LOGGER.info("End");
    }

    /** DELETE /employees/{id} (doc 4 "Implement REST DELETE Service") */
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        employeeService.deleteEmployee(id);
        LOGGER.info("End");
    }
}
