package com.team11.cab.service;

import java.util.ArrayList;

import com.team11.cab.model.CourseEvent;

public interface CourseEventService {

	ArrayList<CourseEvent> findAllCourseEvents();

	CourseEvent findCourseEvent(Integer ceid);

	CourseEvent createCourseEvent(CourseEvent courseEvent);

	CourseEvent changeCourseEvent(CourseEvent courseEvent);

	void removeCourseEvent(CourseEvent courseEvent);

}