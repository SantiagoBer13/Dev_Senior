package com.code.exercise3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RepositoryStudent {

    private List<Student> students = new LinkedList<>();

    public void addStudent(String name, int age, String status) {
        Student student = new Student(name, age, status);
        this.students.add(student);
    }

    public void deleteStudentsWithStatusInactive() {
        Iterator<Student> iterator = this.students.iterator();
    
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStatus().equalsIgnoreCase("Inactive")) {
                iterator.remove();
            }
        }
    }

    public List<Student> getStudentsList() {
        return this.students;
    }

}
