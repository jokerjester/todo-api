package com.jokerjester.entity.wrapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class TaskDeleteWrapper {
	
	@Id
	@NotNull
	@NotBlank
	String id;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
