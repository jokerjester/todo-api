package com.jokerjester.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jokerjester.entity.Task;

public interface TaskRepository extends MongoRepository<Task, String>{

}
