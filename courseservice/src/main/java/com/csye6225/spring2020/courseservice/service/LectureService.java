package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.spring2020.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.spring2020.courseservice.datamodel.Lecture;

public class LectureService {
//static HashMap<String, Lecture> lect_Map = InMemoryDatabase.getLectureDB();
	static DynamoDbConnector dynamodb;
	DynamoDBMapper mapper;
	DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	
	public LectureService() {
		dynamodb = new DynamoDbConnector();
		dynamodb.init();
		mapper = new DynamoDBMapper(dynamodb.getClient());
	}
	
	// Getting a list of all lectures 
	// GET "..webapi/lectures"
	public List<Lecture> getAllLectures() {	
		//Getting the list
		List<Lecture> list = mapper.scan(Lecture.class, scanExpression);
		/*for (Lecture lect : lect_Map.values()) {
			list.add(lect);
		}*/
		return list ;
	}

	// Adding a lecture
	public Lecture addLecture(String course, String courseMaterial, int lectureNum, String announcement, String lectureName) {
		// Next Id 
		//long nextAvailableId = lect_Map.size() + 1;
		
		//Create a Lecture Object
		Lecture lect = new Lecture( course, courseMaterial, lectureNum, announcement, lectureName);
		mapper.save(lect);
		return lect;
	}
	
	
	// Getting One lecture
	public Lecture getLecture(String lect_name) {		
		 //Simple HashKey Load
		Lecture lect1 = mapper.load(Lecture.class, lect_name);
	    System.out.println(lect1.toString());		
		return lect1;
	}
	
	// Deleting a lecture
	public Lecture deleteLecture(String lect_name) {
		Lecture del_lect = mapper.load(Lecture.class, lect_name);
		if (del_lect!=null) {
			mapper.delete(del_lect);
		}
		return del_lect;
	}
	
	// Updating Lecture Info
	public Lecture updateLectureInformation(String lect_name, Lecture lect) {	
		Lecture old_num = mapper.load(Lecture.class, lect_name);
		lect_name = old_num.getLectureNum() + old_num.getCourse();
		old_num.setLectureNum(lect.getLectureNum());
		old_num.setCourseMaterial(lect.getCourseMaterial());
		old_num.setAnnouncement(lect.getAnnouncement());
		mapper.save(old_num);
		return old_num;
	}
	
	// Get lectures by course
	public List<Lecture> getLecturesByCourse(String course) {	
		//Getting the list
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":courseName", new AttributeValue().withS(course));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
        		.withFilterExpression("course= :courseName").withExpressionAttributeValues(eav);
		List<Lecture> lect_list = mapper.scan(Lecture.class, scanExpression);
		return lect_list ;
	}
	
}

