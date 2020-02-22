package com.csye6225.spring2020.courseservice.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.csye6225.spring2020.courseservice.service.CourseService;

@Path("/courses")
public class CourseResource {
	CourseService courseservice = new CourseService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Course> getCourseByDeparment(
			@QueryParam("department") String department) {
		
		if (department == null) {
			return courseservice.getAllCourses();
		}
		return courseservice.getCourseByDepartment(department);
		
	}
	
	// ... webapi/course/1 
	@GET
	@Path("/{courseName}")
	@Produces(MediaType.APPLICATION_XML)
	public Course getCourse(@PathParam("courseName") String courseName) {
		System.out.println("Professor Resource: Looking for: " + courseName);
		return courseservice.getCourse(courseName);
	}
	
	@DELETE
	@Path("/{courseName}")
	@Produces(MediaType.APPLICATION_XML)
	public Course deleteCourse(@PathParam("courseName") String courseName) {
		return courseservice.deleteCourse(courseName);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(Course course) {
			course.setCourseName(course.getCourseName());
			course.setDepartment(course.getDepartment());
			course.setLecture(course.getLecture());
			course.setProfessor(course.getProfessor());
			course.setNumofstudents(course.getNumofstudents());
			course.setTa(course.getTa());

		
			return courseservice.addCourse(course.getCourseName(), course.getDepartment(), course.getLecture(), course.getProfessor(), course.getTa(), course.getNumofstudents());
	}
	
	@PUT
	@Path("/{courseName}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateProfessor(@PathParam("courseName") String courseName, 
			Course course) {
		return courseservice.updateCourseInformation(courseName, course);
	}
	

	
	
}
