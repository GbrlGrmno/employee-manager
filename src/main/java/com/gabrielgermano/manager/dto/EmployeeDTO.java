package com.gabrielgermano.manager.dto;

import java.math.BigDecimal;

public class EmployeeDTO {

    private String name;
    private String email;
    private String position;
    private BigDecimal salary;

    public EmployeeDTO(String name, String email, String position, BigDecimal salary) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
