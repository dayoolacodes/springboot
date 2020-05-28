package io.javabrains.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;
	
	
	public List<Lesson> getAllLessons(String topicId){
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByTopicId(topicId)
		.forEach(lessons::add);
		return lessons;
	}
	
	public Lesson getLesson(String id) {
		
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return lessonRepository.findById(id).get();
	}

	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
//		topics.add(topic);
	}

	public void updateLesson(Lesson lesson) {
		
		lessonRepository.save(lesson);
	
//		for(int i=0; i<topics.size(); i++) {
//			Topics t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic); 
//				return;
//			}
//			
//		}
		
	}

	public void deleteLesson(String id) {
		lessonRepository.deleteById(id);
//		topics.removeIf(t->t.getId().equals(id));
		
	}

}
