package com.csye6225.spring2020.courseservice.datamodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Department")
@XmlRootElement
public class Department {
	String deptName;
	String deptId;
	int numofstudents;
	
	public Department() {
		
	}
	
	public Department(String deptName, String deptId, int numofstudents ) {
		this.deptName=deptName;
		this.deptId=deptId;
		this.numofstudents=numofstudents;
	}
	
	@DynamoDBAttribute(attributeName="numofstudents")
	@XmlElement(name="numofstudents")
	public int getNumofstudents() {
		return numofstudents;
	}

	public void setNumofstudents(int numofstudents) {
		this.numofstudents = numofstudents;
	}
	
	@DynamoDBAttribute(attributeName="deptName")
	@XmlElement(name="deptName")
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName=deptName;
	}
	
	@DynamoDBHashKey(attributeName="deptId")
	@XmlElement(name="deptId")
	public String getDeptId() {
		return deptId;
	}
	
	public void setDeptId(String deptId) {
		this.deptId=deptId;
	}
	
	@DynamoDBIgnore
	@Override
	public String toString() {
		return "deptName=" + getDeptName() + ", deptId=" + getDeptId()+", numofstudents="+getNumofstudents();
	}

}
