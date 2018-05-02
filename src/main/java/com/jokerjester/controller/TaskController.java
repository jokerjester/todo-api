package com.jokerjester.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jokerjester.entity.wrapper.TaskChangeStatusWrapper;
import com.jokerjester.entity.wrapper.TaskDeleteWrapper;
import com.jokerjester.entity.wrapper.TaskInsertWrapper;
import com.jokerjester.entity.wrapper.TaskUpdateWrapper;
import com.jokerjester.exception.SystemException;
import com.jokerjester.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	TaskService taskService;

	@GetMapping(path = "/tasks")
	public Object findAll() {
		return taskService.findAll();
	}

	@GetMapping(path = "/tasks/{id}")
	public Object findOne(@PathVariable(name = "id") String id) throws SystemException {
		return taskService.findById(id);
	}

	@PutMapping(path = "/tasks")
	public Object insertTask(@Valid @RequestBody TaskInsertWrapper task) throws SystemException {
		return taskService.insert(task);
	}

	@PostMapping(path = "/tasks")
	public Object updateTask(@Valid @RequestBody TaskUpdateWrapper task) throws SystemException {
		taskService.update(task);
		return new ResponseEntity<>(new CustomSuccessResponse(HttpStatus.OK, new Date(), "/tasks", "Update Successfully!"), HttpStatus.OK);
	}

	@DeleteMapping(path = "/tasks")
	public Object updateTask(@Valid @RequestBody TaskDeleteWrapper task) throws SystemException {
		taskService.delete(task);
		return new ResponseEntity<>(new CustomSuccessResponse(HttpStatus.OK, new Date(), "/tasks", "Delete Successfully!"), HttpStatus.OK);
	}

	@PostMapping(path = "/tasks/change-status")
	public Object changeStatus(@Valid @RequestBody TaskChangeStatusWrapper task) throws SystemException {
		taskService.changeStatus(task);
		return new ResponseEntity<>(new CustomSuccessResponse(HttpStatus.OK, new Date(), "/tasks/change-status", "Update Successfully!"), HttpStatus.OK);
	}

	@SuppressWarnings("unused")
	@ResponseBody
	private class CustomSuccessResponse {
		
		HttpStatus httpStatus;
		Date timestamp;
		String uri;
		String description;
		
		public CustomSuccessResponse() {}

		public CustomSuccessResponse(HttpStatus httpStatus, Date timestamp, String uri, String description) {
			super();
			this.httpStatus = httpStatus;
			this.timestamp = timestamp;
			this.uri = uri;
			this.description = description;
		}

		public HttpStatus getHttpStatus() {
			return httpStatus;
		}

		public void setHttpStatus(HttpStatus httpStatus) {
			this.httpStatus = httpStatus;
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

		public void setDescription(String description) {
			this.description = description;
		}
			
	}
}
