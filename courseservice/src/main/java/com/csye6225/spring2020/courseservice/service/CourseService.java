package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.csye6225.spring2020.courseservice.datamodel.DynamoDbConnector;


public class CourseService {
	static DynamoDbConnector dynamodb;
	DynamoDBMapper mapper;
	DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	

	public CourseService() {	
		dynamodb = new DynamoDbConnector();
		dynamodb.init();
		mapper = new DynamoDBMapper(dynamodb.getClient());		
	}

	public List<Course> getAllCourses(){
		
		List<Course> course_list = mapper.scan(Course.class, scanExpression);
		ArrayList<Course> list = new ArrayList<>();
		return course_list;
	}
	
	public Course addCourse(String courseName, String department, String lecture, String professor, String ta, int numofstudents) {
		Course course = new Course(courseName, department, lecture , professor, ta, numofstudents);
		mapper.save(course);
		return course;
	}
	
	public Course getCourse(String courseName) {
		
		Course course1 = mapper.load(Course.class, courseName);
		System.out.println("Item retrieved: ");
		System.out.println(course1.toString());
		
		return course1;
		
	}

	public Course deleteCourse(String courseName) {
		Course del_course = mapper.load(Course.class, courseName);
		mapper.delete(del_course);
		return del_course;
	}
	
	public Course updateCourseInformation(String courseName, Course course) {
		Course old_course= mapper.load(Course.class, courseName);
		courseName= old_course.getCourseName();
		old_course.setDepartment(course.getDepartment());
		old_course.setLecture(course.getLecture());
		old_course.setProfessor(course.getProfessor());
		old_course.setNumofstudents(course.getNumofstudents());
		old_course.setTa(course.getTa());
		return course;			
	}
	
	public List<Course> getCourseByDepartment(String department) {	
		//Getting the list
		ArrayList<Course> list = new ArrayList<>();
		
		List<Course> course_list = mapper.scan(Course.class, scanExpression);
		
		for (Course course : course_list) {
			if (course.getDepartment().equals(department)) {
				list.add(course);
			}
		}
		return list ;
	}
	
	
}
