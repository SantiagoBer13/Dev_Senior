package com.dev.Model;

public class Department {

    private Integer department_id;
    private String department_name;
    private Integer location_id;
    
    public Department(Integer department_id, String department_name, Integer location_id) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.location_id = location_id;

    }

    public Integer getDepartment_id() {
        return department_id;
    }
    public String getDepartment_name() {
        return department_name;
    }
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
    public Integer getLocation_id() {
        return location_id;
    }
    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

}
