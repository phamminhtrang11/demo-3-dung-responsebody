package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student("Pham Trang", "1", 16, 1, "10", "10A"));
        students.add(new Student("Ngoc Nga", "2", 16, 2, "10", "10A"));
        students.add(new Student("Anh Ba", "3", 17, 3, "11", "11B"));
        students.add(new Student("Ngoc Linh", "4", 16, 4, "11", "11B"));
    }

    @GetMapping("/students/{class}")

    public ResponseEntity<List<Student>> getStudentsByClass(@PathVariable("class") String className) {
        List<Student> studentsByClass1 = new ArrayList<>();

        for (Student student : students) {
            if (student.getClassName().equalsIgnoreCase(className)) {
                studentsByClass1.add(student);
            }
        }

        if (studentsByClass1.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(studentsByClass1, HttpStatus.OK);
    }

    @PostMapping(value = "/students")
    public MyRe getStudentsByClass(@RequestBody RequestStudent requestStudent) {
        String className = requestStudent.getClassName();
        MyRe mr = new MyRe();
        List<Student> studentsByClass = new ArrayList<>();

        if (students == null || students.size() == 0) {
            mr.setCode("01");
            mr.setMessage("Ko tim thay");
            mr.setLstStudent(studentsByClass);
            return mr;
        }

        for (Student student : students) {
            try {
                if (student.getClassName().equalsIgnoreCase(className)) {
                    studentsByClass.add(student);
                }
            } catch (Exception ex) {
                mr.setCode("99");
                mr.setMessage("gap loi");
                return mr;
            }
        }

        if (studentsByClass.isEmpty()) {
            mr.setCode("01");
            mr.setMessage("Ko tim thay");
        } else {
            mr.setCode("00");
            mr.setMessage("Thanh cong");
        }

        mr.setLstStudent(studentsByClass);
        return mr;
    }
}

