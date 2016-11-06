package com.idea.mcq.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Ruchira
 *
 */
@Entity
public class Mcq extends ModelEntityBase{

	private String name;

	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Answer> answers;

	private String description;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Subject subject;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
