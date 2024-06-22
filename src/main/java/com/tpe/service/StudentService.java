package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        boolean emailIsExist = studentRepository.existsByEmail(studentDTO.getEmail());

        if (emailIsExist && !studentDTO.getEmail().equals(student.getEmail())){

            throw new ConflictException("email is already exist");
        }

        student.setName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setGrade(studentDTO.getGrade());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());

        studentRepository.save(student);


    }

    public Page<Student> getAllWithPage(Pageable pageable) {

        return studentRepository.findAll(pageable);
    }

    public List<Student> findStudent(String lastName){
        return studentRepository.findByLastName(lastName);
    }

    public List<Student> findAllEqualGrades(Integer grade) {

        return  studentRepository.findAllEqualGrades(grade);
    }

    public StudentDTO findStudentDTOById(Long id) {
        return studentRepository.findStudentDTOById(id).orElseThrow(()-> new ResourceNotFoundException("Student not found by id : "+id));

    }
}
