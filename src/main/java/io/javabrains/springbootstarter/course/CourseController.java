package io.javabrains.springbootstarter.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topics;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	
	@RequestMapping("/alltopics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id){
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/alltopics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable  String id){
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/alltopics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topics(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/alltopics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String id,@PathVariable String topicId) {
		
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/alltopics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}









