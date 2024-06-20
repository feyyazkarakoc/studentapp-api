package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void createStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())){
            throw new ConflictException("Email already exists");

        }
        studentRepository.save(student);
    }

    public Student findStudent(Long id) {

        return  studentRepository.findById(id).orElseThrow(()-> new  ResourceNotFoundException("Student not found with id : "+id));

    }

    public void deleteStudent(Long id) {
        Student student = findStudent(id);
        studentRepository.deleteById(id);
    }

    public void updateStudent(Long id, StudentDTO studentDTO) {
        Student student = findStudent(id);


    }
}
