package com.csye6225.spring2020.courseservice.datamodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;

@DynamoDBTable(tableName="Course")
@XmlRootElement
public class Course {
	String courseName;
	String lecture;
	String professor;
	String ta;
	int numofstudents;
	String department;
	
	public Course() {
		
	}

	public Course(String courseName, String department, String lecture, String professor, String ta, int numofstudents) {
		this.department = department;
		this.courseName = courseName;
		this.lecture = lecture;
		this.professor = professor;
		this.ta = ta;
		this.numofstudents = numofstudents;
	}

	@DynamoDBHashKey(attributeName="courseName")
	@XmlElement(name="courseName")
	public String getCourseName() {
		return courseName;
	}

	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@DynamoDBAttribute(attributeName="numofstudents")
	@XmlElement(name="numofstudents")
	public int getNumofstudents() {
		return numofstudents;
	}

	public void setNumofstudents(int numofstudents) {
		this.numofstudents = numofstudents;
	}

	@DynamoDBAttribute(attributeName="lecture")
	@XmlElement(name="lecture")
	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	@DynamoDBAttribute(attributeName="professor")
	@XmlElement(name="professor")
	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	@DynamoDBAttribute(attributeName="ta")
	@XmlElement(name="ta")
	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}
	
	@DynamoDBAttribute(attributeName="department")
	@XmlElement(name="department")
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@DynamoDBIgnore
	@Override
	public String toString() { 
		return "courseName=" + getCourseName() + ", department=" + getDepartment()+",lecture="+getLecture()
				+ ", Professor=" + getProfessor() + ", ta=" + getTa()+", numofstudents="+getNumofstudents();
	}

}