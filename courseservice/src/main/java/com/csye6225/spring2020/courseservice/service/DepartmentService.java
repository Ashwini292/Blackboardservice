package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.spring2020.courseservice.datamodel.Department;
import com.csye6225.spring2020.courseservice.datamodel.DynamoDbConnector;

public class DepartmentService {
	static DynamoDbConnector dynamodb;
	DynamoDBMapper mapper;
	DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	
	public DepartmentService() {
		dynamodb = new DynamoDbConnector();
		dynamodb.init();
		mapper = new DynamoDBMapper(dynamodb.getClient());
	}
	

	public List<Department> getAllDepartments() {	
		//Getting the list
		List<Department> list = mapper.scan(Department.class, scanExpression);
		return list ;
	}

	// Adding a department
	public Department addDepartment(String deptName, String deptId, int numofstudents) {

		Department dept = new Department(deptName, deptId, numofstudents);
		mapper.save(dept);
		return dept;
	}
	
	
	// Getting One Department
	public Department getDepartment(int deptId) {

		 Department dept1 = mapper.load(Department.class, deptId);
	     System.out.println("Item retrieved:");
	     System.out.println(dept1.toString());
		
		return dept1;
	}
	
	// Deleting a department
	public Department deleteDepartment(String deptId) {
		Department del_dept = mapper.load(Department.class, deptId);
		if (del_dept != null) {
			mapper.delete(del_dept);
		}
		return del_dept;
	}
	
	// Updating Department Info
	public Department updateDepartmentInformation(String deptId, Department dept) {	
		Department olddeptObject = mapper.load(Department.class, deptId);
		deptId = olddeptObject.getDeptId();
		olddeptObject.setDeptName(dept.getDeptName());
		olddeptObject.setNumofstudents(dept.getNumofstudents());
		mapper.save(olddeptObject);
		return olddeptObject;
	}
	
	public List<Department> getDepartmentByStudents(int numofstudents) {	
		//Getting the list
		
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":numstudents", new AttributeValue().withN(Integer.toString(numofstudents)));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
        		.withFilterExpression("numofstudents <= :numstudents").withExpressionAttributeValues(eav);
		List<Department> dept_list = mapper.scan(Department.class, scanExpression);

		return dept_list;
			
	}

	
}

