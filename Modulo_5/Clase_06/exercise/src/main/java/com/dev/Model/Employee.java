package com.dev.Model;

import java.util.Date;

public class Employee {
    private Integer employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private Date hire_date;
    private Integer job_id;
    private Long salary;
    private Integer manager_id;
    private Integer department_id;

    public Employee(Integer employee_id, String first_name, String last_name, String email, String phone_number,
            Date hire_date, Integer job_id, Long salary, Integer manager_id, Integer department_id) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
        this.manager_id = manager_id;
        this.department_id = department_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    @Override
    public String toString() {
        return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
                + ", email=" + email + ", phone_number=" + phone_number + ", hire_date=" + hire_date + ", job_id="
                + job_id + ", salary=" + salary + ", manager_id=" + manager_id + ", department_id=" + department_id
                + "]";
    }
        
}
