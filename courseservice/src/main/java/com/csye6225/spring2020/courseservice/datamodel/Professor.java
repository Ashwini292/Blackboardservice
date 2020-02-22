package com.csye6225.spring2020.courseservice.datamodel;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor {
	private String id;
	private String firstName;
	private String lastName;
	private String department;
	private String professorId;
	private String joiningDate;
	private String course;
	
	public Professor() {
		
	}
	
	public Professor(String professorId, String firstName, 
			String lastName, String department, String joiningDate, String course) {
		this.professorId = professorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.joiningDate = joiningDate;
		this.course = course;
	}
	
	@XmlElement(name="firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@XmlElement(name="department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@XmlElement(name="professorId")
	public String getProfessorId() {
		return professorId;
	}
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	
	@XmlElement(name="joiningDate")
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate.toString();
	}

	@XmlElement(name="lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@XmlElement(name="course")
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course=course;
	}
	
	@Override
	public String toString() { 
		return "ProfId=" + getProfessorId() + ", firstName=" + getFirstName()+"lastName="+getLastName()
				+ ", department=" + getDepartment() + ", joiningDate=" + getJoiningDate()+", course="+getCourse();
	}
}