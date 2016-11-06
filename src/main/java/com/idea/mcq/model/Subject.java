package com.idea.mcq.model;

import javax.persistence.Entity;

/**
 * @author Ruchira
 *
 */
@Entity
public class Subject  extends ModelEntityBase{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
