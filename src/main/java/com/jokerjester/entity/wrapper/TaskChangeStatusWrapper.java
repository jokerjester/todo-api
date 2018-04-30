package com.jokerjester.entity.wrapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class TaskChangeStatusWrapper {
	
	@Id
	@NotNull
	@NotBlank
	String id;
	
	@Size(max=1)
	String status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
