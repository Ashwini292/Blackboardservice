package com.csye6225.spring2020.courseservice.resource;

import java.util.ArrayList;
import java.util.Date;
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

import com.csye6225.spring2020.courseservice.datamodel.Professor;
import com.csye6225.spring2020.courseservice.service.ProfessorsService;


//.. /webapi/myresource
@Path("/professors")
public class ProfessorsResource {

	ProfessorsService profService = new ProfessorsService();
	
	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Professor> getProfessors() {
		return profService.getAllProfessors();
	}*/	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Professor> getProfessorsByDeparment(
			@QueryParam("department") String department) {
		
		if (department == null) {
			return profService.getAllProfessors();
		}
		System.out.println(department);
		return profService.getProfessorsByDepartment(department);
		
	}
	
	// ... webapi/professor/1 
	@GET
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_XML)
	public Professor getProfessor(@PathParam("professorId") String profId) {
		System.out.println("Professor Resource: Looking for: " + profId);
		return profService.getProfessor(profId);
	}
	
	@DELETE
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_XML)
	public Professor deleteProfessor(@PathParam("professorId") String profId) {
		return profService.deleteProfessor(profId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor addProfessor(Professor prof) {
			prof.setProfessorId(prof.getFirstName()+" "+prof.getLastName());
			prof.setFirstName(prof.getFirstName());
			prof.setLastName(prof.getLastName());
			prof.setJoiningDate(prof.getJoiningDate());
			prof.setCourse(prof.getCourse());
			prof.setDepartment(prof.getDepartment());
		
			return profService.addProfessor(prof.getFirstName(), prof.getLastName(), prof.getDepartment(), prof.getJoiningDate(), prof.getCourse());
	}
	
	@PUT
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor updateProfessor(@PathParam("professorId") String profId, 
			Professor prof) {
		return profService.updateProfessorInformation(profId, prof);
	}
	
	/*public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
		profService.addProfessor(firstName, lastName, department, joiningDate);
	}*/
}

