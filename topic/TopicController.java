package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	
	@RequestMapping("/topics")
	public String AllTopics() {
		
		return "All Topics List:";
	}
	
	
	@RequestMapping("/alltopics")
	public List<Topics> getAllTopics(){
		
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/alltopics/{id}")
	public Topics getTopic(@PathVariable  String id){
		
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/alltopics")
	public void addTopic(@RequestBody Topics topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/alltopics/{id}")
	public void updateTopic(@RequestBody Topics topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/alltopics/{id}")
	public void deleteTopic(@RequestBody Topics topic, @PathVariable String id) {
		topicService.deleteTopic(id);
	}

}









