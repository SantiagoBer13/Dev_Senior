package com.code;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalisisCalificacionesEstudiantes {
    
    private List<Student> students;
    
    public AnalisisCalificacionesEstudiantes(List<String> students) {
        this.students = students.stream().map(e -> {
            String[] datos = e.split(",");
            return new Student(
                datos[0],
                datos[1],
                Double.parseDouble(datos[2]) 
            );
        }).collect(Collectors.toList());
    }

    public Map<String, Double> calculateAverageGradesByStudent(){
        return this.students.stream()
            .collect(Collectors.groupingBy(student -> student.getName(),Collectors.averagingDouble(student -> student.getGrade())));
    }

    public Map<String, Integer> countStudentsByCourse(){
        return this.students.stream()
            .collect(Collectors.groupingBy(student -> student.getCourse(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }

    public List<Student> filterGradesHigher(Double grade){
        return this.students.stream()
                .filter(student -> student.getGrade() > grade)
                .collect(Collectors.toList());
    }

    public Student getGradeHigher(){
        return this.students.stream()
                .max(Comparator.comparing(student -> student.getGrade()))
                .orElse(null);
    }

    public class Student{
        private String name;
        private String course;
        private Double grade;
        public Student(String name, String course, Double grade) {
            this.name = name;
            this.course = course;
            this.grade = grade;
        }
        public String getName() {
            return name;
        }
        public String getCourse() {
            return course;
        }
        public Double getGrade() {
            return grade;
        }
    }
}
