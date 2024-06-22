package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        map.put("message","Student İS created successfulLy");
        map.put("status","true");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }


    @GetMapping("/query")//http://localhost:8080/students/query?id=1 + GET
    public ResponseEntity<Student> getStudent(@RequestParam("id") Long id){

        Student student = studentService.findStudent(id);
        return new ResponseEntity<>(student,HttpStatus.OK);

    }


    @GetMapping("/{id}")//http://localhost:8080/students/1 + GET
    public ResponseEntity<Student> getStudentByPath(@PathVariable("id") Long id){
        Student student = studentService.findStudent(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")//http://localhost:8080/students/2 + DELETE
    public ResponseEntity<Map<String,String>> deleteStudent(@PathVariable("id") Long id){

        studentService.deleteStudent(id);
        Map<String,String> map = new HashMap<>();
        map.put("message","Student is deleted successfully");
        map.put("status","true");
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @PutMapping("/{id}")//http://localhost:8080/students/1 + PUT + JSON
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO){
        studentService.updateStudent(id,studentDTO);
        String message = "Student is updated successfully";
        return new ResponseEntity<>(message,HttpStatus.OK) ;
    }

    @GetMapping("/page") //http://localhost:8080/students/page?page=0&size=2&sort=name&direction=ASC +GET
    public ResponseEntity<Page<Student>> getAllWithPage(
                                                @RequestParam("page") int page,
                                                @RequestParam("size") int size,
                                                @RequestParam("sort") String prop,
                                                @RequestParam("direction") Sort.Direction direction){
        Pageable pageable = PageRequest.of(page,size,Sort.by(direction,prop));
        Page<Student> studentPage = studentService.getAllWithPage(pageable);
        return ResponseEntity.ok(studentPage) ;
    }

    @GetMapping("/querylastname")//http://localhost:8080/students/querylastname?lastName=kaya +GET
    public ResponseEntity<List<Student>> getStudentByLastName(@RequestParam("lastName") String lastName){
        List<Student> studentList = studentService.findStudent(lastName);
        return ResponseEntity.ok(studentList);

    }

    @GetMapping("/query/{grade}")//http://localhost:8080/students/query/70 +GET
    public ResponseEntity<List<Student>> getStudentEqualsGrade(@PathVariable("grade") Integer grade){
        List<Student> list = studentService.findAllEqualGrades(grade);
        return ResponseEntity.ok(list);
    }


    @GetMapping("/query/dto")//http://localhost:8080/students/query/dto?id=1 +GET
    public ResponseEntity<StudentDTO> getStudentDTOById(@RequestParam("id") Long id){
        StudentDTO studentDTO = studentService.findStudentDTOById(id);
        return ResponseEntity.ok(studentDTO);
    }



}
