package com.generation.service;

import com.generation.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest
{
    private StudentService studentService;

    @BeforeEach
    void setUp()
    {
        studentService = new StudentService();
    }

    @Test
    @DisplayName("Student 001, John Doe successfully found.")
    void findStudent()
    {
        // Upon finding student 001
        Student student = studentService.findStudent("001");

        // Succeed
        assertNotNull(student, "Student 001 is found.");
        assertEquals("John Doe", student.getName(),
                "Name of the student is John Doe.");
    }

    @Test
    @DisplayName("Student 001, 002 and 003 are subscribed to the platform")
    void isSubscribed()
    {
        assertTrue(studentService.isSubscribed("001"));
        assertTrue(studentService.isSubscribed("002"));
        assertTrue(studentService.isSubscribed("003"));
    }

    @Test
    @DisplayName("Student 004 is NOT subscribed to the platform.")
    void isNotSubscribed()
    {
        assertFalse(studentService.isSubscribed("004"));
    }
}
