package com.example.service;


import com.example.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService  {


	Todo createTodo(Todo todo);

	Todo updateTodo(Todo todo);

	List<Todo> getAllTodo();

	Optional<Todo> findOne(Integer id);

	void deleteTodo(Integer todoId);




  

}
