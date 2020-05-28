package io.javabrains.springbootstarter.lesson;

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
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	

	
	
	@RequestMapping("/alltopics/topicId/courses/{id}")
	public List<Lesson> getAllLessons(@PathVariable String id){
		return lessonService.getAllLessons(id);
	}
	
	@RequestMapping("/alltopics/{topicId}/courses/{id}")
	public Lesson getCourse(@PathVariable  String id){
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/alltopics/{topicId}/courses")
	public void addCourse(@RequestBody Lesson course,@PathVariable String topicId) {
		course.setTopic(new Topics(topicId,"",""));
		lessonService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/alltopics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Lesson course, @PathVariable String id,@PathVariable String topicId) {
		
		lessonService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/alltopics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		lessonService.deleteCourse(id);
	}

}









