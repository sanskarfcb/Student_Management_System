package com.example.Sms.Repository;

import com.example.Sms.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    //Optional<Student> findByid(long roll_no);
}
