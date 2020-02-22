package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Course;

public class CourseService {
static HashMap<String, Course> course_Map = InMemoryDatabase.getCourseDB();

	public CourseService() {
		
	}

	public List<Course> getAllCourses(){
		
		ArrayList<Course> list = new ArrayList<>();
		for(Course course: course_Map.values()) {
			list.add(course);
		}
		return list;
	}
	
	public Course addCourse(String courseName, String lecture, String department, String professor, String ta, int numofstudents) {
		long nextAvailableId = course_Map.size() + 1;

		Course course = new Course(courseName, lecture , professor, department, ta, numofstudents);
		course_Map.put(courseName, course);
		return course;
	}
	
	public Course getCourse(String courseName) {
		
		Course course1 = course_Map.get(courseName);
		System.out.println("Item retrieved: ");
		System.out.println(course1.toString());
		
		return course1;
		
	}

	public Course deleteCourse(String courseName) {
		Course del_course = course_Map.get(courseName);
		course_Map.remove(courseName);
		return del_course;
	}
	
	public Course updateCourseInformation(String courseName, Course course) {
		Course old_course= course_Map.get(courseName);
		courseName= old_course.getCourseName();
		old_course.setCourseName(course.getCourseName());
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
		for (Course course : course_Map.values()) {
			if (course.getDepartment().equals(department)) {
				list.add(course);
			}
		}
		return list ;
	}
	
	
}
