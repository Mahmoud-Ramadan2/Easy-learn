package com.example.EasyLearn.service;

import com.example.EasyLearn.exception.EntityNotFoundException;
import com.example.EasyLearn.model.Student;
import com.example.EasyLearn.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student findStudentWithCourses (int studentId){
        Optional <Student> result = studentRepository.findStudentWithCourses(studentId);
        Student student = null;
        if(result.isPresent()){
            student = result.get();
        }
        else{
            throw  new EntityNotFoundException("Student with id=" + studentId + " not found.");
        }
        return  student;
    }
}
