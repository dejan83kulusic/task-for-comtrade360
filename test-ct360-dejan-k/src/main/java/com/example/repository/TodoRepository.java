package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
