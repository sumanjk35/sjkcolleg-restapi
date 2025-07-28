package com.sjkcollege.controller;

import com.sjkcollege.model.Student;
import com.sjkcollege.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sjkcollege")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students/{rollNumber}")
    public ResponseEntity<Student> getStudentByRollNumber(@PathVariable String rollNumber) {
        Student student = studentService.getStudentByRollNumber(rollNumber);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/students/{rollNumber}")
    public ResponseEntity<Student> updateStudent(@PathVariable String rollNumber, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(rollNumber, student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/students/{rollNumber}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String rollNumber) {
        studentService.deleteStudent(rollNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}