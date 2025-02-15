package com.example.EasyLearn;

import com.example.EasyLearn.model.Course;
import com.example.EasyLearn.model.Instructor;
import com.example.EasyLearn.model.Student;
import com.example.EasyLearn.service.CourseService;
import com.example.EasyLearn.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class EasyLearnApplication {

	public static void main(String[] args) {SpringApplication.run(EasyLearnApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner(CourseService courseService, InstructorService instructorService){
		return runner -> {
			addcoursewithstudents(courseService,instructorService);
		};
	}


private void addcoursewithstudents(CourseService courseService, InstructorService instructorService){
		Course course = new Course("course SPS");
		Instructor instructor = new Instructor("SPS","SPS");
		course.setInstrcutor(instructor);
	Student student1 = new Student("PM","SPS","SPS");
	Student student2 = new Student("PP","SPS","SPS");
	course.addStudent(student1);
	course.addStudent(student2);
	instructor.add(course);
	instructorService.save(instructor);
	System.out.println("DONEEEEE");



}
}


