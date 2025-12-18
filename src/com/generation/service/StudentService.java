package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    // TODO - generate dummy students
    public StudentService()
    {
        subscribeStudent(new Student("001", "John Doe", "johndoe@gmail.com", new Date("01/01/2000")));
        subscribeStudent(new Student("002", "May Fair", "mayfair@gmail.com", new Date("02/02/2010")));
        subscribeStudent(new Student("003", "Steve Smith", "stevesmith@gmail.com", new Date("03/03/2015")));
    }

    public void subscribeStudent(Student student)
    {
        students.put(student.getId(), student);
    }

    public Student findStudent(String studentId)
    {
        if (students.containsKey(studentId))
        {
            return students.get(studentId);
        }
        return null;
    }

    public boolean isSubscribed(String studentId)
    {
        return findStudent(studentId) != null;
    }

    public void showSummary()
    {
        System.out.println("Enrolled Students");

        for (String key : students.keySet())
        {
            Student student = students.get(key);
            System.out.println(student);

            List<Course> enrolledCourses = student.getApprovedCourses();
            System.out.println("\tEnrolled Courses");

            if (enrolledCourses.size() > 0)
            {
                for (Course course : enrolledCourses)
                {
                    System.out.println("\t" + course);
                }
            }
            else
            {
                System.out.println("\t\tNo course found.");
            }
        }
    }

    public void enrollToCourse(String studentId, Course course)
    {
        if (students.containsKey(studentId))
        {
            students.get(studentId).enrollToCourse(course);
        }
    }

    // TODO - gradeStudent
    public void gradeStudent(String studentId, Course course)
    {
        // find the student by the id
        Student student = students.get(studentId);

        // pass the course credit to the student to add on
        student.setGrade(course.getCredits());

        System.out.println(
                "Total grade of student: "
                        + studentId
                        + " is: "
                        + student.getGrade()
        );
    }
}
