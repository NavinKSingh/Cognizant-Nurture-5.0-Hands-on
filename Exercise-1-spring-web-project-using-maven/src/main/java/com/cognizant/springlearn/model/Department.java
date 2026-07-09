package com.cognizant.springlearn.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Department {

    @NotNull(message = "id should not be null")
    private Long id;

    @NotNull(message = "name should not be null")
    @NotBlank(message = "name should not be blank")
    @Size(min = 1, max = 30, message = "name should be between 1 and 30 characters")
    private String name;

    public Department() {
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

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}
