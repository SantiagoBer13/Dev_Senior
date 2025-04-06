package com.code.exercise3;

public class Student {

    private static int idGeneral = 0;
    private String id;
    private String name;
    private int age;
    private String status;

    public Student(String name, int age, String status) {
        Student.idGeneral++;
        this.id = "EST-" + Student.idGeneral;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    private String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", status=" + status + "]";
    }
    
}
