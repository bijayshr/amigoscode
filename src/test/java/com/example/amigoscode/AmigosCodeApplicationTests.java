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

import static org.mockito.Mockito.when;

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




}
