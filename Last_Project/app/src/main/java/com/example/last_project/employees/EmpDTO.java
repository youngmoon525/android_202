package com.example.last_project.employees;

public class EmpDTO {
    String employee_id, name, department_name, city, country_name;

    public EmpDTO(String employee_id, String name, String department_name, String city, String country_name) {
        this.employee_id = employee_id;
        this.name = name;
        this.department_name = department_name;
        this.city = city;
        this.country_name = country_name;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
