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

import com.csye6225.spring2020.courseservice.datamodel.Lecture;
import com.csye6225.spring2020.courseservice.service.LectureService;

@Path("/lectures")
public class LectureResource {

LectureService lectservice = new LectureService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Lecture> getLectureByCourse(
			@QueryParam("course") String course) {
		
		if (course == null) {
			return lectservice.getAllLectures();
		}
		return lectservice.getLecturesByCourse(course);
		
	}
	
	// ... webapi/lecture/1 
	@GET
	@Path("/{lectureName}")
	@Produces(MediaType.APPLICATION_XML)
	public Lecture getProfessor(@PathParam("lectureName") String lect_name) {
		System.out.println("Professor Resource: Looking for: " + lect_name);
		return lectservice.getLecture(lect_name);
	}
	
	@DELETE
	@Path("/{lectureName}")
	@Produces(MediaType.APPLICATION_XML)
	public Lecture deleteProfessor(@PathParam("lectureName") String lect_name) {
		return lectservice.deleteLecture(lect_name);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture addLecture(Lecture lect) {
		System.out.println(lect.toString());
		lect.setLectureNum(lect.getLectureNum());
		lect.setLectureName(lect.getLectureName());
		lect.setCourse(lect.getCourse());
		lect.setCourseMaterial(lect.getCourseMaterial());
		lect.setAnnouncement(lect.getAnnouncement());
		
			return lectservice.addLecture(lect.getCourse(), lect.getCourseMaterial(), lect.getLectureNum(), lect.getAnnouncement(), lect.getLectureName());
	}
	
	@PUT
	@Path("/{lectureName}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture updateLecture(@PathParam("lectureName") String lect_name, 
			Lecture lect) {
		return lectservice.updateLectureInformation(lect_name, lect);
	}

}
