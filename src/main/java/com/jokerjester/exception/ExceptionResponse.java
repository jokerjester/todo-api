package com.jokerjester.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;


public class ExceptionResponse {

	private HttpStatus httpStatus;
	private Date timestamp;
	private String uri;
	private String description;
	
	public ExceptionResponse() {}

	public ExceptionResponse(HttpStatus httpStatus,Date timestamp, String message, String details) {
		super();
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
		this.uri = message;
		this.description = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String details) {
		this.description = details;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
}
