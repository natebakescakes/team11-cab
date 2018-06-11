package com.team11.cab.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team11.cab.model.CourseEvent;
import com.team11.cab.repository.CourseEventRepository;

@Service
public class CourseEventServiceImpl implements CourseEventService {
	
	@Resource
	private CourseEventRepository courseEventRepository;
	

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.CourseEventService#findAllCourseEvents()
	 */
	@Override
	@Transactional
	public ArrayList<CourseEvent> findAllCourseEvents() {
		ArrayList<CourseEvent> l = (ArrayList<CourseEvent>) courseEventRepository.findAll();
		return l;
	}


	/* (non-Javadoc)
	 * @see edu.iss.cats.service.CourseEventService#findCourseEvent(java.lang.String)
	 */
	@Override
	@Transactional
	public CourseEvent findCourseEvent(Integer ceid) {
		return courseEventRepository.findOne(ceid);

	}

	
	/* (non-Javadoc)
	 * @see edu.iss.cats.service.CourseEventService#createCourseEvent(edu.iss.cats.model.CourseEvent)
	 */
	@Override
	@Transactional
	public CourseEvent createCourseEvent(CourseEvent courseEvent) {
		return courseEventRepository.saveAndFlush(courseEvent);
	}

	
	/* (non-Javadoc)
	 * @see edu.iss.cats.service.CourseEventService#changeCourseEvent(edu.iss.cats.model.CourseEvent)
	 */
	@Override
	@Transactional
	public CourseEvent changeCourseEvent(CourseEvent courseEvent) {
		return courseEventRepository.saveAndFlush(courseEvent);
	}

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.CourseEventService#removeCourseEvent(edu.iss.cats.model.CourseEvent)
	 */
	@Override
	@Transactional
	public void removeCourseEvent(CourseEvent courseEvent) {
		courseEventRepository.delete(courseEvent);
	}

}
