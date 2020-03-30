package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.csye6225.spring2020.courseservice.datamodel.DynamoDbConnector;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class StudentService {
	static DynamoDbConnector dynamodb;
	DynamoDBMapper mapper;
	DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	
	public StudentService() {
		dynamodb= new DynamoDbConnector();
		dynamodb.init();
		mapper = new DynamoDBMapper(dynamodb.getClient());
		
	}
	
	// Getting a list of all student 
	public List<Student> getAllStudents() {	
		//Getting the list
		
		List<Student> stud_list = mapper.scan(Student.class, scanExpression);
		return stud_list ;
	}

	// Adding a student
	public Student addStudent(String firstName, String LastName, int studentId, ArrayList courses, String department, String image) {
		
		//Create a Student Object
		Student stud = new Student(firstName, LastName, studentId, courses, department, image);
		mapper.save(stud);
		return stud;
	}
	
	
	// Getting One Student
	public Student getStudent(int studId) {
		 Student stud2 = mapper.load(Student.class, studId);
	     System.out.println("Item retrieved:");
	     System.out.println(stud2.toString());
		
		return stud2;
	}
	
	// Deleting a student
	public Student deleteStudent(int studId) {
		Student del_student = mapper.load(Student.class, studId);
		mapper.delete(del_student);
		return del_student;
	}
	
	// Updating Student Info
	public Student updateStudentInformation(int studId, Student stud) {	
		Student oldStudObject = mapper.load(Student.class, studId);
		studId = oldStudObject.getStudentId();
		oldStudObject.setFirstName(stud.getFirstName());
		oldStudObject.setLastName(stud.getLastName());
		oldStudObject.setCourses(stud.getCourses());
		oldStudObject.setDepartment(stud.getDepartment());
		oldStudObject.setImage(stud.getImage());
		return oldStudObject;
	}
	
	// Get students in a department 
	public List<Student> getStudentsByDepartment(String department) {	
		//Getting the list
		List<Student> stud_list = mapper.scan(Student.class, scanExpression);
		ArrayList<Student> list = new ArrayList<>();
		for (Student stud : stud_list) {
			if (stud.getDepartment().equals(department)) {
				list.add(stud);
			}
		}
		return list ;
	}
	

	

}
