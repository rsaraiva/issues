package com.rsaraiva.labs.issues.core;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CommonEntity {

	@Id @GeneratedValue
	private Long id;
	
	@Column(name = "create_on", nullable = false)
	private LocalDateTime createdOn;
	
	@Column(name = "updated_on")
	private LocalDateTime updatedOn;
	
	public CommonEntity() {
		this.createdOn = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
}
