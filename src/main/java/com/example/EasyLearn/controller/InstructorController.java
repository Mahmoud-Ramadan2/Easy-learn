package com.example.EasyLearn.controller;


import com.example.EasyLearn.model.Course;
import com.example.EasyLearn.model.Instructor;
import com.example.EasyLearn.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Instructor> instructors = instructorService.findAll();
        model.addAttribute("instructors", instructors);
        return "instructor/instructor-list";
    }

    @GetMapping("/course-list")
    public String courcesList(@RequestParam("instId") int id, Model model) {
            Instructor instructor = instructorService.findById(id);
        List<Course> courses = instructor.getCourses();
        model.addAttribute("courses", courses);
        return "instructor/course-list";
    }


}
