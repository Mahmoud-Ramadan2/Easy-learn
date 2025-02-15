package com.example.EasyLearn;

import com.example.EasyLearn.model.Course;
import com.example.EasyLearn.model.Instructor;
import com.example.EasyLearn.model.Student;
import com.example.EasyLearn.service.CourseService;
import com.example.EasyLearn.service.InstructorService;
import com.example.EasyLearn.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Set;

@SpringBootApplication
public class EasyLearnApplication {

	public static void main(String[] args) {SpringApplication.run(EasyLearnApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService ){
		return runner -> {
			findStudentWithCourses(studentService);
		};
	}


//private void addcoursewithstudents(CourseService courseService, InstructorService instructorService){
//		Course course = new Course("course SPS");
//		Instructor instructor = new Instructor("SPS","SPS");
//		course.setInstrcutor(instructor);
//	Student student1 = new Student("PM","SPS","SPS");
//	Student student2 = new Student("PP","SPS","SPS");
//	course.addStudent(student1);
//	course.addStudent(student2);
//	instructor.add(course);
//	instructorService.save(instructor);
//	System.out.println("DONEEEEE");
//}

//	private void findInstrructorWithCourses(CourseService courseService) {
//		Course course = courseService.findCourseWithStudents(17);
//		Set<Student> students =  course.getStudents();
//		System.out.println(course);
//		System.out.println(students	);
//		System.out.println("DONEEEEE");
//	}

	private void findStudentWithCourses(StudentService studentService) {
		Student student  = studentService.findStudentWithCourses(13);
		Set<Course> courses =  student.getCourses();
		System.out.println(student);
		System.out.println(courses	);
		System.out.println("DONEEEEE");
	}

}


