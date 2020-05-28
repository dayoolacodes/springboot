package io.javabrains.springbootstarter.lesson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import io.javabrains.springbootstarter.course.Course;
import io.javabrains.springbootstarter.topic.Topics;

@Entity
public class Lesson {
	
	@Id
	private String id;
	private String lessonNote;
	private String Description;
	
	@OneToOne
	private Course course;
	
	public Lesson(){
		
	}
	
	
	public Lesson(String id, String lessonNote, String description, String course) {
		super();
		this.id = id;
		this.lessonNote = lessonNote;
		Description = description;
		this.course = new Course(course,"","","");
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLesson() {
		return lessonNote;
	}
	public void setLesson(String name) {
		this.lessonNote = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}
