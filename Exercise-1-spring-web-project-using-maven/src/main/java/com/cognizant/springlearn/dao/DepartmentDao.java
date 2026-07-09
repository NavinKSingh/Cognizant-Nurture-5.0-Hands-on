package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;

@Repository
public class DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);

    @SuppressWarnings("unchecked")
    private static final ArrayList<Department> DEPARTMENT_LIST;

    static {
        LOGGER.info("Loading DEPARTMENT_LIST from employee.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList", ArrayList.class);
    }

    public ArrayList<Department> getAllDepartments() {
        LOGGER.info("Start");
        LOGGER.debug("Returning {} departments", DEPARTMENT_LIST.size());
        LOGGER.info("End");
        return DEPARTMENT_LIST;
    }
}
