package com.example.amigoscode.service.impl;

import com.example.amigoscode.model.Student;
import com.example.amigoscode.repository.StudentRepository;
import com.example.amigoscode.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author bijayshrestha on 6/21/22
 * @project amigoscode
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        List<Student> students = studentRepository.findAll();
        log.info("****** GETTING STUDENTS FROM DB STUDENTS *******, {}", students);
        return students;
    }

    public Student getStudentById(Integer id){
        Optional<Student> student = studentRepository.findById(id);
        log.info("------- GETTING STUDENT BY ID FROM DB STUDENTS ------, {}", student);
        if(!student.isPresent()){
            throw new IllegalStateException("Student ID not found.");
        }
        return student.get();
    }

    @Override
    public Student addStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
       return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if(!exist){
            throw new IllegalStateException("Student with studentId: " + studentId + " does not exists!");
        }
        studentRepository.deleteById(studentId);
    }

    @Override
    @Transactional
    public void updateStudent(Integer id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Student with ID: " + id + "does not exist!"));

        if(name != null && name.length() > 0 &&
                !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email Taken");
            }
            student.setEmail(email);
        }

    }
}
