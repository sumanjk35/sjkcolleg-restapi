package com.sjkcollege.service;

import com.sjkcollege.exception.CustomException;
import com.sjkcollege.model.Student;
import com.sjkcollege.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        logger.info("Creating student: {}", student);
        validateStudent(student);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepository.findAll();
    }

    public Student getStudentByRollNumber(String rollNumber) {
        logger.info("Fetching student with Roll Number: {}", rollNumber);
        return studentRepository.findById(rollNumber)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with Roll Number: " + rollNumber));
    }

    public Student updateStudent(String rollNumber, Student studentDetails) {
        logger.info("Updating student with Roll Number: {}", rollNumber);
        Student student = getStudentByRollNumber(rollNumber);
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setAddress(studentDetails.getAddress());
        student.setDepartment(studentDetails.getDepartment());
        return studentRepository.save(student);
    }

    public void deleteStudent(String rollNumber) {
        logger.info("Deleting student with Roll Number: {}", rollNumber);
        Student student = getStudentByRollNumber(rollNumber);
        studentRepository.delete(student);
    }

    private void validateStudent(Student student) {
        if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
            throw new CustomException("First Name is required");
        }
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            throw new CustomException("Email ID is required");
        }
        if (student.getDepartment() == null || student.getDepartment().isEmpty()) {
            throw new CustomException("Department is required");
        }
    }
}