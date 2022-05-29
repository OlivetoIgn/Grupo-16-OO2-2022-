package com.unla.aulas.dto;

public class DepartmentDto {

    private int id;

    private String department;

    public DepartmentDto(){}

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public DepartmentDto(int id, String department) {
        this.department = department;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
