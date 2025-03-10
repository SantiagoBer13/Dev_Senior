package com.code.exercise1;

import java.sql.Date;

public class Task {

    private static int idClase = 0;
    private String id;
    private String name;
    private Date date;
    private boolean completed;

    public Task(String name) {
        ++idClase;
        this.id = "T-1" + idClase;
        this.name = name;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task [Date = " + date + ", name = " + name + ", completed = " + completed + "]";
    }

}
