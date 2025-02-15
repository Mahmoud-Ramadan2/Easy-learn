package com.example.EasyLearn.repository;

import com.example.EasyLearn.model.Student;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @EntityGraph(attributePaths = {"courses"})
    @Query("select s from Student s where s.id = :studentId")
    Optional<Student> findStudentWithCourses(int studentId);
}
