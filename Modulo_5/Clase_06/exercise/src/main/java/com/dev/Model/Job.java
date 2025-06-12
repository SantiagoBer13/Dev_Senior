package com.dev.Model;

public class Job {

    private Integer job_id;
    private String job_title;
    private Long min_salary;
    private Long max_salary;
    
    public Job(Integer job_id, String job_title, Long min_salary, Long max_salary) {
        this.job_id = job_id;
        this.job_title = job_title;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Long getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Long min_salary) {
        this.min_salary = min_salary;
    }

    public Long getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Long max_salary) {
        this.max_salary = max_salary;
    }

    

}
