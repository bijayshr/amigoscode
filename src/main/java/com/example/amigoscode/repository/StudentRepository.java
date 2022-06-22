package com.example.amigoscode.repository;

import com.example.amigoscode.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bijayshrestha on 6/21/22
 * @project amigoscode
 */
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Integer> {

    Optional<Student> findStudentByEmail(String email);
}
