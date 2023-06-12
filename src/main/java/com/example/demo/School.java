package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Student> students = new ArrayList<>();

    public School() {
        students.add(new Student("Pham Trang", "1", 16, 1,"10","10A" ));
        students.add(new Student("Ngoc Nga", "2", 16,  2, "10","10A"));
        students.add(new Student("Anh Ba", "3", 17, 3,"11","11B" ));
        students.add(new Student("Ngoc Linh", "4", 16, 4,"11","11B"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

