package com.naga.com.controller;

import com.naga.com.model.Student;
import com.naga.com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("read")
    public List<Student> read(){
        return studentService.getAllStudents();
    }

    @PostMapping("/save")
    public Student createStudent( @RequestBody Student student) {
        System.out.println("Received student: " + student);
        return studentService.saveStudent(student);

    }

}
