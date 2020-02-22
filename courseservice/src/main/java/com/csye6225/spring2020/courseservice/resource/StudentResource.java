package com.csye6225.spring2020.courseservice.resource;

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

import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.csye6225.spring2020.courseservice.service.StudentService;

@Path("/students")
public class StudentResource {


		StudentService studService = new StudentService();
		
		/*@GET
		@Produces(MediaType.APPLICATION_XML)
		public List<Student> getStudents() {
			return studService.getAllStudents();
		}*/	
		
		@GET
		@Produces(MediaType.APPLICATION_XML)
		public List<Student> getStudentsByDeparment(
				@QueryParam("department") String department) {
			
			if (department == null) {
				return studService.getAllStudents();
			}
			return studService.getStudentsByDepartment(department);
			
		}
		
		// ... webapi/studessor/1 
		@GET
		@Path("/{studentId}")
		@Produces(MediaType.APPLICATION_XML)
		public Student getStudent(@PathParam("studentId") int studId) {
			System.out.println("Student Resource: Looking for: " + studId);
			return studService.getStudent(studId);
		}
		
		@DELETE
		@Path("/{studentId}")
		@Produces(MediaType.APPLICATION_XML)
		public Student deleteStudent(@PathParam("studentId") int studId) {
			return studService.deleteStudent(studId);
		}
		
		@POST
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_JSON)
		public Student addStudent(Student stud) {
			stud.setStudentId(stud.getStudentId() );
			stud.setFirstName(stud.getFirstName());
			stud.setLastName(stud.getLastName());
			stud.setCourses(stud.getCourses());
			stud.setDepartment(stud.getDepartment());
			stud.setImage(stud.getImage());
				return studService.addStudent(stud.getFirstName(), stud.getLastName(), stud.getStudentId(), stud.getCourses(), stud.getDepartment(), stud.getImage());
		}
		
		@PUT
		@Path("/{studentId}")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_JSON)
		public Student updateStudent(@PathParam("studentId") int studId, 
				Student stud) {
			return studService.updateStudentInformation(studId, stud);
		}

}
