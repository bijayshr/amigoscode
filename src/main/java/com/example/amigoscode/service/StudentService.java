package com.example.amigoscode.service;

import com.example.amigoscode.model.Student;

import java.util.List;

/**
 * @author bijayshrestha on 6/21/22
 * @project amigoscode
 */
public interface StudentService {
    List<Student> getStudents();

    void addStudent(Student student);

    void deleteStudent(Long id);

    void updateStudent(Long id, String name, String email);
}
