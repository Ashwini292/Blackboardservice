package com.csye6225.spring2020.courseservice.datamodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Department {
	String deptName;
	int deptId;
	int numofstudents;
	
	public Department() {
		
	}
	
	public Department(String deptName, int deptId, int numofstudents ) {
		this.deptName=deptName;
		this.deptId=deptId;
		this.numofstudents=numofstudents;
	}
	
	@XmlElement(name="numofstudents")
	public int getNumofstudents() {
		return numofstudents;
	}

	public void setNumofstudents(int numofstudents) {
		this.numofstudents = numofstudents;
	}

	@XmlElement(name="deptName")
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName=deptName;
	}
	
	@XmlElement(name="deptId")
	public int getDeptId() {
		return deptId;
	}
	
	public void setDeptId(int deptId) {
		this.deptId=deptId;
	}
	
	@Override
	public String toString() {
		return "deptName=" + getDeptName() + ", deptId=" + getDeptId()+", numofstudents="+getNumofstudents();
	}

}
