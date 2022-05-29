package com.unla.aulas.dto;


public class CarrerDto {
    private String carrer;
    private DepartmentDto department;

    public CarrerDto(){}

    public CarrerDto(String carrer, DepartmentDto department) {
        this.carrer = carrer;
        this.department = department;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }
}
