package com.csye6225.spring2020.courseservice.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.spring2020.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Professor;

public class ProfessorsService {
	static DynamoDbConnector dynamoDb;
	DynamoDBMapper mapper;
	DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	
	public ProfessorsService() {
		dynamoDb = new DynamoDbConnector();
		dynamoDb.init();
		mapper = new DynamoDBMapper(dynamoDb.getClient());
	}
	
	public List<Professor> getAllProfessors() {	
		//Getting the list

		List<Professor> prof_list =  mapper.scan(Professor.class, scanExpression);
		return prof_list ;
	}

	// Adding a professor
	public Professor addProfessor(String firstName, String lastName, String department, String joiningDate, String course) {
		String profId = firstName+lastName;
		Professor prof = new Professor(profId, firstName , lastName, department, joiningDate, course);
		mapper.save(prof);
		return prof;
	}
	
	
	// Getting One Professor
	public Professor getProfessor(String profId) {
		 Professor prof2 = mapper.load(Professor.class, profId);
	     System.out.println("Item retrieved:");
	     System.out.println(prof2.toString());
		
		return prof2;
	}
	
	// Deleting a professor
	public Professor deleteProfessor(String profId) {
		
		DynamoDBDeleteExpression deleteexpression = new DynamoDBDeleteExpression();
		Professor deletedProfDetails = mapper.load(Professor.class, profId);
		mapper.delete(deletedProfDetails);
		return deletedProfDetails;
	}
	
	// Updating Professor Info
	public Professor updateProfessorInformation(String profId, Professor prof) {	
		Professor oldProfObject = mapper.load(Professor.class, profId);
		profId = oldProfObject.getProfessorId();
		oldProfObject.setJoiningDate(prof.getJoiningDate());
		oldProfObject.setCourse(prof.getCourse());
		oldProfObject.setDepartment(prof.getDepartment());
		return oldProfObject;
	}
	
	// Get professors in a department 
	public List<Professor> getProfessorsByDepartment(String department) {	
		//Getting the list		
		List<Professor> prof_list =  mapper.scan(Professor.class, scanExpression);       
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor professor : prof_list) {
			if (professor.getDepartment().equals(department)) {
				list.add(professor);
				System.out.println(list);
			}
		}

		return list ;
	}	
	
	// Get professors for a year with a size limit
	
}
