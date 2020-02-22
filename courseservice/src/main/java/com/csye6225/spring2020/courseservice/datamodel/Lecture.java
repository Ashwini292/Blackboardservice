package com.csye6225.spring2020.courseservice.datamodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lecture {
	private String course;
	private String courseMaterial;
	private int lectureNum;
	private String announcement;
	private String lectureName;
	
	public Lecture() {
		
	}
	
	public Lecture(String course, String courseMaterial, int lectureNum, String announcement, String lectureName) {
		this.course = course;
		this.courseMaterial=courseMaterial;
		this.lectureNum=lectureNum;
		this.announcement=announcement;
		this.lectureName=lectureName;
	}
	@XmlElement(name="course")
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@XmlElement(name="courseMaterial")
	public String getCourseMaterial() {
		return courseMaterial;
	}
	
	public void setCourseMaterial(String courseMaterial) {
		this.courseMaterial=courseMaterial;
	}
	
	@XmlElement(name="lectureNum")
	public int getLectureNum(){
		System.out.println(lectureNum);
		return lectureNum;
	}
	
	public void setLectureNum(int lectureNum) {
		this.lectureNum=lectureNum;
	}
	
	@XmlElement(name="announcement")
	public String getAnnouncement() {
		return announcement;
	}
	
	public void setAnnouncement(String announcement) {
		this.announcement=announcement;
	}
	
	@XmlElement(name="lectureName")
	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	
	@Override
	public String toString() { 
		return "Material=" + getCourseMaterial() + ", LectureNum=" + getLectureNum() + ", Course=" + getCourse()
				+ ", Announcement=" + getAnnouncement()+", LectureName="+ getLectureName();
	}
}
