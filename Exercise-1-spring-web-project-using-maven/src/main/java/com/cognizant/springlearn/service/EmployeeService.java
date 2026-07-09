package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("Start");
        ArrayList<Employee> employees = employeeDao.getAllEmployees();
        LOGGER.info("End");
        return employees;
    }

    @Transactional
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        employeeDao.updateEmployee(employee);
        LOGGER.info("End");
    }

    @Transactional
    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        employeeDao.deleteEmployee(id);
        LOGGER.info("End");
    }
}
