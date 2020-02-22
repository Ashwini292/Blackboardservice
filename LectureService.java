package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Lecture;

public class LectureService {
static HashMap<String, Lecture> lect_Map = InMemoryDatabase.getLectureDB();
	
	public LectureService() {
	}
	
	// Getting a list of all lectures 
	// GET "..webapi/lectures"
	public List<Lecture> getAllLectures() {	
		//Getting the list
		ArrayList<Lecture> list = new ArrayList<>();
		for (Lecture lect : lect_Map.values()) {
			list.add(lect);
		}
		return list ;
	}

	// Adding a lecture
	public Lecture addLecture(String course, String courseMaterial, int lectureNum, String announcement, String lectureName) {
		// Next Id 
		long nextAvailableId = lect_Map.size() + 1;
		
		//Create a Lecture Object
		Lecture lect = new Lecture( course, courseMaterial, lectureNum, announcement, lectureName);

		lect_Map.put(lectureName, lect);
		return lect;
	}
	
	
	// Getting One lecture
	public Lecture getLecture(String lect_name) {		
		 //Simple HashKey Load
		Lecture lect1 = lect_Map.get(lect_name);
	    System.out.println(lect1.toString());		
		return lect1;
	}
	
	// Deleting a lecture
	public Lecture deleteLecture(String lect_name) {
		Lecture del_lect = lect_Map.get(lect_name);
		lect_Map.remove(lect_name);
		return del_lect;
	}
	
	// Updating Lecture Info
	public Lecture updateLectureInformation(String lect_name, Lecture lect) {	
		Lecture old_num = lect_Map.get(lect_name);
		lect_name = old_num.getLectureNum()+old_num.getCourse();
		old_num.setLectureNum(lect.getLectureNum());
		old_num.setCourse(lect.getCourse());
		old_num.setCourseMaterial(lect.getCourseMaterial());
		old_num.setAnnouncement(lect.getAnnouncement());
		return old_num;
	}
	
	// Get lectures by course
	public List<Lecture> getLecturesByCourse(String course) {	
		//Getting the list
		ArrayList<Lecture> list = new ArrayList<>();
		for (Lecture lect : lect_Map.values()) {
			if (lect.getCourse().equals(course)) {
				list.add(lect);
			}
		}
		return list ;
	}
	
}

