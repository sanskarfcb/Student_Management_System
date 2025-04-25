package com.example.Sms.Controller;


import com.example.Sms.Model.Student;
import com.example.Sms.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/get")
    public List<Student> getStudent(){
        return  studentRepository.findAll();
    }

    @GetMapping("/{roll_no}")
    public Optional<Student> getbyid(@PathVariable Long roll_no){
        return studentRepository.findById(roll_no);
    }

    @PutMapping("/{roll_no}")
    public Student UpdateStudent(@PathVariable Long roll_no  , @RequestBody Student student){
        return studentRepository.findById(roll_no).
                map(existingStudent -> {
                    existingStudent.setFirstName(student.getFirstName());
                    existingStudent.setLastName(student.getLastName());
                    existingStudent.setPlace(student.getPlace());
                    return studentRepository.save(existingStudent);
                }).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @DeleteMapping("/{roll_no}")
    public String deleteUser(@PathVariable Long roll_no){
        studentRepository.deleteById(roll_no);
        return "Student deleted successfully!!!";
    }
}
