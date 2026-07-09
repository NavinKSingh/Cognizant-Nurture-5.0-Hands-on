package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    @SuppressWarnings("unchecked")
    private static final ArrayList<Employee> EMPLOYEE_LIST;

    static {
        LOGGER.info("Loading EMPLOYEE_LIST from employee.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", ArrayList.class);
    }

    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("Start");
        LOGGER.debug("Returning {} employees", EMPLOYEE_LIST.size());
        LOGGER.info("End");
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                LOGGER.debug("Updated employee id={}", employee.getId());
                LOGGER.info("End");
                return;
            }
        }
        LOGGER.warn("Employee id={} not found for update", employee.getId());
        throw new EmployeeNotFoundException("Employee not found with id: " + employee.getId());
    }

    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        boolean removed = EMPLOYEE_LIST.removeIf(e -> e.getId().equals(id));
        if (!removed) {
            LOGGER.warn("Employee id={} not found for delete", id);
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        LOGGER.debug("Deleted employee id={}", id);
        LOGGER.info("End");
    }
}
