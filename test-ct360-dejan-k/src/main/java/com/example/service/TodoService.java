package com.example.service;


import com.example.exception.ResourceNotFoundException;
import com.example.model.Todo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TodoService  {

	Todo createTodo(Todo todo);

	Todo updateTodo(Todo todo);

	List<Todo> getAllTodo();
	Optional < Todo > getEmployeeById(Integer id)
			throws ResourceNotFoundException;

	Map< String, Boolean > deleteTodo(Integer id)
			throws ResourceNotFoundException;






}
