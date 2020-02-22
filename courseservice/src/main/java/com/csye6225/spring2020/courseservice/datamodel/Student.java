package com.csye6225.spring2020.courseservice.datamodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	String firstName;
	String lastName;
	int studentId;
	String courses;
	String department;
	String image;
	
	public Student() {
		
	}
	
	public Student(String firstName, String LastName, int studentId, String courses, String department, String image) {
		this.firstName=firstName;
		this.lastName=LastName;
		this.studentId=studentId;
		this.courses=courses;
		this.department=department;
		this.image = image;
	}
	
	@XmlElement(name="firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name="lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name="studentId")
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@XmlElement(name="courses")
	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		System.out.println(courses);
		this.courses = courses;
	}

	@XmlElement(name="department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@XmlElement(name="image")
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image=image;
	}
	
	@Override
	public String toString() {
		return "Student Id ="+getStudentId()+ ", firstName ="+getFirstName()+", lastName="+getLastName()+", Courses="+getCourses()+", Department="+getDepartment()+", Image="+getImage();
	}
}
