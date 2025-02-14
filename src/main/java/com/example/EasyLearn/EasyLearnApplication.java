package com.example.EasyLearn;

import com.example.EasyLearn.model.Instructor;
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
	public CommandLineRunner commandLineRunner(InstructorService instructorService){
		return runner -> {
			  showCourses(instructorService);
		};
	}


private void showCourses(InstructorService instructorService){
		Instructor instructor = instructorService.findInstrructorWithCourses(1);


	if (instructor != null) {
		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
	} else {
		System.out.println("Instructor not found with ID: 1");
	}
	System.out.println("DONEEEEE");



}
}


