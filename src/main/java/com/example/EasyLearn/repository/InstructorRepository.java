package com.example.EasyLearn.repository;


import com.example.EasyLearn.model.Instructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {


    // To handel FetchType.LAZY for the courses relationship in the Instructor
    //@Query("select i from Instructor i left join fetch i.courses where i.id= :instructorId")
   // Optional<Instructor> findInstrructorWithCourses(@Param("instructorId") int instructorId);


    // another way to handel lazy fetch
    // EntityGraph annotation allows to specify  relationship should be fetched eagerly for a specific query.
    @EntityGraph(attributePaths = {"courses"})
    @Query("select i from Instructor i where i.id= :instructorId")
    Optional<Instructor> findInstrructorWithCourses(int instructorId);

}
