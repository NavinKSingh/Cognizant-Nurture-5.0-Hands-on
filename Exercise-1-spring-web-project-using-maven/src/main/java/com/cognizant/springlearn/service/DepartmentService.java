package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.model.Department;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentDao departmentDao;

    public ArrayList<Department> getAllDepartments() {
        LOGGER.info("Start");
        ArrayList<Department> departments = departmentDao.getAllDepartments();
        LOGGER.info("End");
        return departments;
    }
}
