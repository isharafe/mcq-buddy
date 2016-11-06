package com.idea.mcq.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * base entity class for holding the id and version properties,
 * and other db common properties
 * @author Ruchira
 *
 */
@MappedSuperclass
public abstract class ModelEntityBase {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private Long version;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
	
}
