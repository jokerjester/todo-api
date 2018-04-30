package com.jokerjester.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
@JsonInclude(value=Include.NON_NULL)
@Document(collection = "tasks")
public class Task {
	
	@Id
	String id;
	
	@NotNull
	@NotBlank
	@Size(max=50)
	String subject;
	
	@Size(max=200)
	String detail;
	
	@Size(max=1)
	String status;
	
	@Version 
	Long version;
		
	public Task() {
		
	}

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

	@Override
	public String toString() {
		return "Task [id=" + id + ", subject=" + subject + ", detail=" + detail + ", status=" + status + "]";
	}	
	
}
