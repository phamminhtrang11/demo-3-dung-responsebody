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

    @PostMapping("/students")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsByClass(@RequestBody RequestStudent requestStudent) {
        String className = requestStudent.getClassName();

        List<Student> studentsByClass = new ArrayList<>();
        for (Student student : students) {
            if (student.getClassName().equalsIgnoreCase(className)) {
                studentsByClass.add(student);
            }
        }

        if (studentsByClass.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(studentsByClass, HttpStatus.OK);
    }
}
