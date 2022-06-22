package com.example.amigoscode;

import com.example.amigoscode.model.Student;
import com.example.amigoscode.repository.StudentRepository;
import com.example.amigoscode.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class AmigosCodeApplicationTests {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void getStudentsTest(){
        when(studentRepository.findAll()).thenReturn(
                List.of(new Student(
                        "Bijay",
                        "bijay@miu.edu",
                        LocalDate.of(1990, Month.APRIL, 20)),
                        new Student(
                                "Yohannes",
                                "yohannes@miu.edu",
                                LocalDate.of(1996, Month.FEBRUARY, 14)
                        ))
        );
        Assertions.assertEquals(2, studentService.getStudents().size());
    }

    @Test
    public void addStudentTest(){
        Student student = new Student(
                "Test",
                "test@miu.edu",
                LocalDate.of(1995, Month.AUGUST, 20));
        when(studentRepository.save(student)).thenReturn(student);
        Assertions.assertEquals(student, studentService.addStudent(student));
    }

    @Test
    public void findStudentByIdTest(){
        Integer studentId = 1;
        Student student = new Student("FindById Student", "find@miu.edu",
                LocalDate.of(
                        1990, Month.JUNE, 01
                ));
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

//        studentService.deleteStudent(studentId);
//        verify(studentRepository, times(1)).deleteById(studentId);
        Assertions.assertEquals(student, studentService.getStudentById(studentId));
    }


}
