package com.jokerjester.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jokerjester.entity.Task;
import com.jokerjester.entity.wrapper.TaskChangeStatusWrapper;
import com.jokerjester.entity.wrapper.TaskDeleteWrapper;
import com.jokerjester.entity.wrapper.TaskInsertWrapper;
import com.jokerjester.entity.wrapper.TaskUpdateWrapper;
import com.jokerjester.exception.ObjectNotFoundException;
import com.jokerjester.exception.SystemException;
import com.jokerjester.repository.TaskRepository;
import com.mongodb.client.result.UpdateResult;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	public Object findById(String id) throws SystemException{
		Optional<Task> t = taskRepository.findById(id);
		if(!t.isPresent()) {
			throw new ObjectNotFoundException("Object not found!");
		}
		return t.get();
	}
	
	public Object insert(TaskInsertWrapper task) throws SystemException{
		Task newTask = new Task();
		newTask.setId(UUID.randomUUID().toString());
		newTask.setSubject(task.getSubject());
		newTask.setDetail(task.getDetail());
		newTask.setStatus("P");
		return taskRepository.insert(newTask);
	}
	
	public Long update(TaskUpdateWrapper task) throws SystemException {
		if(StringUtils.isEmpty(task.getId())) {
			throw new ObjectNotFoundException("Can not update because the object not found!");
		}
		
		Optional<Task> t = taskRepository.findById(task.getId());
		if(!t.isPresent()) {
			throw new ObjectNotFoundException("Can not update because the object not found!");
		}
		
		Query query = new Query(Criteria.where("id").is(task.getId()));
        Update update = new Update();
        
        if(!StringUtils.isEmpty(task.getDetail())) {
        	update.set("detail", task.getDetail());
        }
        if(!StringUtils.isEmpty(task.getSubject())) {
        	update.set("subject", task.getSubject());
        }
        if(!StringUtils.isEmpty(task.getStatus())) {
        	update.set("status", task.getStatus());
        }

        UpdateResult result = mongoTemplate.updateFirst(query, update, Task.class);
		System.out.println(result);
		
		return result.getModifiedCount();
	}

	

	public Object delete(@Valid TaskDeleteWrapper task) throws SystemException {
		Optional<Task> t = taskRepository.findById(task.getId());
		if(!t.isPresent()) {
			throw new ObjectNotFoundException("Can not delete because the object not found!");
		}
		taskRepository.delete(t.get());
		return task.getId();
	}
	
	public Long changeStatus(TaskChangeStatusWrapper task) throws SystemException {
		if(StringUtils.isEmpty(task.getId())) {
			throw new ObjectNotFoundException("Can not update because the object not found!");
		}
		
		Optional<Task> t = taskRepository.findById(task.getId());
		if(!t.isPresent()) {
			throw new ObjectNotFoundException("Can not update because the object not found!");
		}
		
		Query query = new Query(Criteria.where("id").is(task.getId()));
        Update update = new Update();
        
        if(!StringUtils.isEmpty(task.getStatus())) {
        	update.set("status", task.getStatus());
        }

        UpdateResult result = mongoTemplate.updateFirst(query, update, Task.class);
		System.out.println(result);
		
		return result.getModifiedCount();
	}
	
}
