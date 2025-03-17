package com.example.EasyLearn.controller;

import com.example.EasyLearn.model.Course;
import com.example.EasyLearn.model.Review;
import com.example.EasyLearn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "course/course-list";
    }

    //for TEST
    @PostMapping("show-review-form")
    @ResponseBody
    public String showReviewForm(@RequestParam("courseId") int id) {
        Course course = courseService.findById(id);
        if (course != null) {
            Review review1 = new Review("comment1");
            Review review2 = new Review("comment2");
            course.addReview(review1);
            course.addReview(review2);
            courseService.save(course);
            return "reviews Added";
        }
            return "Course not found!";
    }
    //will delete course and its reviews
    @DeleteMapping ("/delete-course")
    public String deleteCourse(@RequestParam("courseId") int id){
        courseService.deleteById(id);
        return "redirect:/course/list";
    }

    @GetMapping("/show-add-form")
    public String showForm (Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "course/course-form";
    }


}