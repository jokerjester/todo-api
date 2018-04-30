package com.jokerjester.entity.wrapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public class TaskUpdateWrapper {
	
	@Id
	@NotNull
	@NotBlank
	String id;
	
	@NotNull
	@NotBlank
	@Size(max=50)
	String subject;
	
	@Size(max=200)
	String detail;
	
	@Size(max=1)
	String status;
	
	@NotNull
	@Version 
	Long version;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	
}
