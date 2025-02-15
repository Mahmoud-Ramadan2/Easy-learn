package com.example.EasyLearn.service;

import com.example.EasyLearn.exception.EntityNotFoundException;
import com.example.EasyLearn.model.Course;
import com.example.EasyLearn.model.Instructor;
import com.example.EasyLearn.model.Review;
import com.example.EasyLearn.repository.CourseRepository;
import com.example.EasyLearn.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courserRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public CourseService(CourseRepository courserRepository, ReviewRepository reviewRepository) {
        this.courserRepository = courserRepository;
        this.reviewRepository = reviewRepository;
    }

    public Course findById(int id) {
        return courserRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Course with id=" + id + " not found.")
        );

    }

    public List<Course> findAll(){
        return courserRepository.findAll();
    }

    public void save(Course course){
        courserRepository.save(course);
    }


    @Transactional // all must be done or not
    public void addCourseReview(int courseId, Review review){
        Course course = courserRepository.findById(courseId).orElseThrow(
                ()-> new EntityNotFoundException("Course with id=" + courseId + " not found.")
        );
        course.addReview(review);
        reviewRepository.save(review);
    }

    @Transactional
    public Course findCourseWithStudents(int courseId){
       Optional<Course> result = courserRepository.findCourseWithStudents(courseId);
       Course course = null;
       if(result.isPresent()){
           course = result.get();
       }
       else{
           throw new EntityNotFoundException("Course with id=" + courseId + " not found.");
       }

        return course;
    }

    public void deleteById(int id){
        courserRepository.deleteById(id);
    }

}
