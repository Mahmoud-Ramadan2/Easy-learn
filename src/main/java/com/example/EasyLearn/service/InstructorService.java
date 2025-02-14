package com.example.EasyLearn.service;

import com.example.EasyLearn.exception.EntityNotFoundException;
import com.example.EasyLearn.model.Instructor;
import com.example.EasyLearn.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository){
        this.instructorRepository = instructorRepository;
    }

    public Instructor findById(int id){
        Optional<Instructor> result = instructorRepository.findById(id);
        Instructor instructor = null;
        if(result.isPresent()){
            instructor = result.get();
        }
        else{
            throw new EntityNotFoundException("Instructor with id=" + id + " not found.");
        }
        return instructor;
    }


    // using  @Transactional to avoid LazyInitializationException.
    @Transactional
    public Instructor findInstrructorWithCourses(int instructorId) {

        Optional<Instructor> result = instructorRepository.findInstrructorWithCourses(instructorId);
        Instructor instructor = null;
        if(result.isPresent()){
            instructor = result.get();
        }
        else{
            throw new EntityNotFoundException("Instructor with id=" + instructorId + " not found.");
        }
        return instructor;
    }

        public List<Instructor> findAll(){
        return instructorRepository.findAll();
    }
    public void save (Instructor instructor){
        instructorRepository.save(instructor);
    }

    public void deleteByIdD(int id){
        Optional<Instructor> result = instructorRepository.findById(id);
        if(result.isPresent()){
            instructorRepository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Instructor with id=" + id + " not found.");
        }
    }

}
