package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topics> topics = new ArrayList<Topics>(Arrays.asList(
			new Topics("001", "Spring 101", "String Starter"),
			new Topics("002", "Java 101", "Java Starter"),
			new Topics("003", "Spring-Boot 101", "StringBoot Starter")
			));
	
	public List<Topics> getAllTopics(){
		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);;
		return topics;
	}
	
	public Topics getTopic(String id) {
		
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topics topic) {
		topicRepository.save(topic);
//		topics.add(topic);
	}

	public void updateTopic(Topics topic, String id) {
		
		topicRepository.save(topic);
	
//		for(int i=0; i<topics.size(); i++) {
//			Topics t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic); 
//				return;
//			}
//			
//		}
		
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
//		topics.removeIf(t->t.getId().equals(id));
		
	}

}
