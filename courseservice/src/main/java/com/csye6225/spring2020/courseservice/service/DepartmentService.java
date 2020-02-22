package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Professor;
import com.csye6225.spring2020.courseservice.datamodel.Department;

public class DepartmentService {
static HashMap<Integer, Department> dept_Map = InMemoryDatabase.getDepartmentDB();
	
	public DepartmentService() {
	}
	
	// Getting a list of all department 
	// GET "..webapi/departments"
	public List<Department> getAllDepartments() {	
		//Getting the list
		ArrayList<Department> list = new ArrayList<>();
		for (Department dept : dept_Map.values()) {
			list.add(dept);
		}
		return list ;
	}

	// Adding a department
	public Department addDepartment(String deptName, int deptId, int numofstudents) {
		// Next Id 
		long nextAvailableId = dept_Map.size() + 1;
		
		//Create a Department Object
		Department dept = new Department(deptName, deptId, numofstudents);
		int id = deptId;
		dept_Map.put(id, dept);
		return dept;
	}
	
	
	// Getting One Department
	public Department getDepartment(int deptId) {
		
		 //Simple HashKey Load
		 Department dept1 = dept_Map.get(deptId);
	     System.out.println("Item retrieved:");
	     System.out.println(dept1.toString());
		
		return dept1;
	}
	
	// Deleting a department
	public Department deleteDepartment(int deptId) {
		Department del_dept = dept_Map.get(deptId);
		dept_Map.remove(deptId);
		return del_dept;
	}
	
	// Updating Department Info
	public Department updateDepartmentInformation(int deptId, Department dept) {	
		Department olddeptObject = dept_Map.get(deptId);
		deptId = olddeptObject.getDeptId();
		olddeptObject.setDeptName(dept.getDeptName());
		olddeptObject.setDeptId(dept.getDeptId());
		olddeptObject.setNumofstudents(dept.getNumofstudents());
		return olddeptObject;
	}
	
	public List<Department> getDepartmentByStudents(int numofstudents) {	
		//Getting the list
		ArrayList<Department> list = new ArrayList<>();
		for (Department dept : dept_Map.values()) {
			if(dept.getNumofstudents()==numofstudents)
			list.add(dept);
		}
		
		return list;
			
	}

	
}

