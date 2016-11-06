package com.idea.mcq.model;

import javax.persistence.Entity;

/**
 * @author Ruchira
 *
 */
@Entity
public class Answer extends ModelEntityBase{

	/**
	 * name of the channel
	 */
	private String name;
	
	private boolean correct;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
}
