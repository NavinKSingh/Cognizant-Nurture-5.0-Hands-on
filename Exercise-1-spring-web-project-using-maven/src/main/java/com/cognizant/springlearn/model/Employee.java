package com.cognizant.springlearn.model;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * NOTE on dateOfBirth: kept as a plain String (format dd/MM/yyyy) rather than
 * java.util.Date/LocalDate. Spring's XML-based bean wiring (employee.xml)
 * does not have a built-in PropertyEditor to convert a plain string into a
 * Date/LocalDate out of the box (that requires registering a
 * CustomDateEditor), and the assignment's XML-driven data setup is the
 * priority here. If you want strict Date typing, register a
 * CustomEditorConfigurer bean for java.util.Date in the Spring XML context.
 */
public class Employee {

    @NotNull(message = "id should not be null")
    private Long id;

    @NotNull(message = "name should not be null")
    @NotBlank(message = "name should not be blank")
    @Size(min = 1, max = 30, message = "name should be between 1 and 30 characters")
    private String name;

    @NotNull(message = "salary should not be null")
    @DecimalMin(value = "0", message = "salary should be zero or above")
    private Double salary;

    @NotNull(message = "permanent should not be null")
    private Boolean permanent;

    // Expected format dd/MM/yyyy, e.g. 14/05/1990
    private String dateOfBirth;

    @Valid
    private Department department;

    @Valid
    private List<Skill> skills;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
                + ", permanent=" + permanent + ", dateOfBirth=" + dateOfBirth
                + ", department=" + department + ", skills=" + skills + "]";
    }
}
