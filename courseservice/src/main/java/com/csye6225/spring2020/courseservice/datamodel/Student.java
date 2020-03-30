package com.csye6225.spring2020.courseservice.datamodel;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;

@DynamoDBTable(tableName="Student")
@XmlRootElement
public class Student {

	String firstName;
	String lastName;
	int studentId;
	ArrayList<String> courses= new ArrayList<String>();
	String department;
	String image;
	
	public Student() {
		
	}
	
	public Student(String firstName, String LastName, int studentId, ArrayList courses, String department, String image) {
		this.firstName=firstName;
		this.lastName=LastName;
		this.studentId=studentId;
		this.courses=courses;
		this.department=department;
		this.image = image;
	}
	
	@DynamoDBAttribute(attributeName="firstName")
	@XmlElement(name="firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute(attributeName="lastName")
	@XmlElement(name="lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBHashKey(attributeName="studentId")
	@XmlElement(name="studentId")
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@DynamoDBAttribute(attributeName="courses")
	@XmlElement(name="courses")
	public ArrayList getCourses() {
		return courses;
	}

	public void setCourses(ArrayList courses) {
		System.out.println(courses);
		this.courses = courses;
	}

	@DynamoDBAttribute(attributeName="department")
	@XmlElement(name="department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@DynamoDBAttribute(attributeName="image")
	@XmlElement(name="image")
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image=image;
	}
	
	@DynamoDBIgnore
	@Override
	public String toString() {
		return "Student Id ="+getStudentId()+ ", firstName ="+getFirstName()+", lastName="+getLastName()+", Courses="+getCourses()+", Department="+getDepartment()+", Image="+getImage();
	}
}
