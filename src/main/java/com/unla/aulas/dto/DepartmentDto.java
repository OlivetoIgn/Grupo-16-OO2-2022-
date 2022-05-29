package com.unla.aulas.dto;

public class DepartmentDto {

    private String department;

    public DepartmentDto(){}

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public DepartmentDto(String department) {
        this.department = department;
    }
}
