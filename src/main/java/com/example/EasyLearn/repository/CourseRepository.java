package com.example.EasyLearn.repository;

import com.example.EasyLearn.model.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {


    // EntityGraph annotation allows to specify  relationship should be fetched eagerly for a specific query.

    @EntityGraph(attributePaths = {"students"})
    @Query("select c from Course c where c.id = :courseId")
    Optional<Course> findCourseWithStudents(int courseId);


}
