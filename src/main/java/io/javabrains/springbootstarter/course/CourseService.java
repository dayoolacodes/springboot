package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
//		topics.add(topic);
	}

	public void updateCourse(Course course) {
		
		courseRepository.save(course);
	
//		for(int i=0; i<topics.size(); i++) {
//			Topics t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic); 
//				return;
//			}
//			
//		}
		
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
//		topics.removeIf(t->t.getId().equals(id));
		
	}

}
