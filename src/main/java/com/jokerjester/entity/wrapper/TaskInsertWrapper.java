package com.jokerjester.entity.wrapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskInsertWrapper {
		
	@NotNull
	@NotBlank
	@Size(max=50)
	String subject;
	
	@Size(max=200)
	String detail;
	
	@Size(max=1)
	String status;
	

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
}
