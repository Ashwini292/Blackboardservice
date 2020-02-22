package com.csye6225.spring2020.courseservice.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Professor;

public class ProfessorsService {
static HashMap<String, Professor> prof_Map = InMemoryDatabase.getProfessorDB();
	
	public ProfessorsService() {
	}
	
	// Getting a list of all professor 
	// GET "..webapi/professors"
	public List<Professor> getAllProfessors() {	
		//Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			list.add(prof);
		}
		return list ;
	}

	// Adding a professor
	public Professor addProfessor(String firstName, String lastName, String department, String joiningDate, String course) {
		// Next Id 
		long nextAvailableId = prof_Map.size() + 1;
		String profId = firstName+lastName;
		//Create a Professor Object
		Professor prof = new Professor(profId, firstName , lastName, department, joiningDate, course);
		prof_Map.put(profId, prof);
		return prof;
	}
	
	
	// Getting One Professor
	public Professor getProfessor(String profId) {
		
		 //Simple HashKey Load
		 Professor prof2 = prof_Map.get(profId);
	     System.out.println("Item retrieved:");
	     System.out.println(prof2.toString());
		
		return prof2;
	}
	
	// Deleting a professor
	public Professor deleteProfessor(String profId) {
		Professor deletedProfDetails = prof_Map.get(profId);
		//System.out.println(prof_Map);
		//System.out.println(deletedProfDetails);
		prof_Map.remove(profId);
		return deletedProfDetails;
	}
	
	// Updating Professor Info
	public Professor updateProfessorInformation(String profId, Professor prof) {	
		Professor oldProfObject = prof_Map.get(profId);
		profId = oldProfObject.getProfessorId();
		//prof.setProfessorId(profId);
		oldProfObject.setProfessorId(prof.getFirstName()+prof.getLastName());
		oldProfObject.setJoiningDate(prof.getJoiningDate());
		oldProfObject.setCourse(prof.getCourse());
		oldProfObject.setDepartment(prof.getDepartment());
		return oldProfObject;
	}
	
	// Get professors in a department 
	public List<Professor> getProfessorsByDepartment(String department) {	
		//Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			if (prof.getDepartment().equals(department)) {
				list.add(prof);
				System.out.println(list);
			}
		}
		return list ;
	}
	
	// Get professors for a year with a size limit
	
}
