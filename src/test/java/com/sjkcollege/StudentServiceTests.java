package com.sjkcollege;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.sjkcollege.controller.StudentController;
import com.sjkcollege.model.Student;
import com.sjkcollege.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(StudentController.class)
public class StudentServiceTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private Student student;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student("4JK25CV001", "John", "Doe", "john.doe@example.com", "123 Main St", "Computer Science");
    }

    @Test
    public void testCreateStudent() throws Exception {
        when(studentService.createStudent(any(Student.class))).thenReturn(student);

        mockMvc.perform(post("/sjkcollege/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"rollNumber\":\"4JK25CV001\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\",\"address\":\"123 Main St\",\"department\":\"Computer Science\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.rollNumber").value("4JK25CV001"));
    }

    @Test
    public void testGetStudent() throws Exception {
        when(studentService.getStudentByRollNumber("4JK25CV001")).thenReturn(student);

        mockMvc.perform(get("/sjkcollege/students/4JK25CV001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"));
    }

    @Test
    public void testUpdateStudent() throws Exception {
        when(studentService.updateStudent(any(String.class), any(Student.class))).thenReturn(student);

        mockMvc.perform(put("/sjkcollege/students/4JK25CV001")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\",\"address\":\"123 Main St\",\"department\":\"Computer Science\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rollNumber").value("4JK25CV001"));
    }

    @Test
    public void testDeleteStudent() throws Exception {
        doNothing().when(studentService).deleteStudent("4JK25CV001");

        mockMvc.perform(delete("/sjkcollege/students/4JK25CV001"))
                .andExpect(status().isNoContent());
    }
}