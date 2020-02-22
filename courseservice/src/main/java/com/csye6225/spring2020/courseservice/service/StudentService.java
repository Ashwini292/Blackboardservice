package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Student;

public class StudentService {
static HashMap<Integer, Student> stud_Map = InMemoryDatabase.getStudentDB();
	
	public StudentService() {
	}
	
	// Getting a list of all student 
	// GET "..webapi/student"
	public List<Student> getAllStudents() {	
		//Getting the list
		ArrayList<Student> list = new ArrayList<>();
		for (Student stud : stud_Map.values()) {
			list.add(stud);
		}
		return list ;
	}

	// Adding a student
	public Student addStudent(String firstName, String LastName, int studentId, String courses, String department, String image) {
		// Next Id 
		int nextAvailableId = stud_Map.size() + 1;
		
		//Create a Student Object
		Student stud = new Student(firstName, LastName, studentId, courses, department, image);
		stud_Map.put(studentId, stud);
		return stud;
	}
	
	
	// Getting One Student
	public Student getStudent(int studId) {
		
		 //Simple HashKey Load
		 Student stud2 = stud_Map.get(studId);
	     System.out.println("Item retrieved:");
	     System.out.println(stud2.toString());
		
		return stud2;
	}
	
	// Deleting a student
	public Student deleteStudent(int studId) {
		Student del_student = stud_Map.get(studId);
		stud_Map.remove(studId);
		return del_student;
	}
	
	// Updating Student Info
	public Student updateStudentInformation(int studId, Student stud) {	
		Student oldStudObject = stud_Map.get(studId);
		studId = oldStudObject.getStudentId();
		oldStudObject.setStudentId(stud.getStudentId());
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
		ArrayList<Student> list = new ArrayList<>();
		for (Student stud : stud_Map.values()) {
			if (stud.getDepartment().equals(department)) {
				list.add(stud);
			}
		}
		return list ;
	}
	

	

}
