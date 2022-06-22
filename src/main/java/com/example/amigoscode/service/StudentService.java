package com.example.amigoscode.service;

import com.example.amigoscode.model.Student;

import java.util.List;

/**
 * @author bijayshrestha on 6/21/22
 * @project amigoscode
 */
public interface StudentService {
    List<Student> getStudents();

    Student getStudentById(Integer id);

    Student addStudent(Student student);

    void deleteStudent(Integer id);

    void updateStudent(Integer id, String name, String email);
}
