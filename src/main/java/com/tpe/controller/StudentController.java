package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/students") //http://localhost:8080/students + GET + POST + PUT + DELETE
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping//http://localhost:8080/students + GET
    public ResponseEntity<List<Student>> getAll(){

        List<Student> students =  studentService.getAll();
        return ResponseEntity.ok(students);

    }

    @PostMapping //http://localhost:8080/students + POST
    public ResponseEntity<Map<String,String>> createStudent(@Valid @RequestBody Student student){
        studentService.createStudent(student);
        Map<String,String> map = new HashMap<>();
        map.put("message","Student İS created succesSfulLy");
        map.put("status","true");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }


}
