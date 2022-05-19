package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.exception.UserNotFound;
import com.example.model.Todo;
import com.example.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public  class TodoServiceImpl implements TodoService {

	@Autowired
	private  TodoRepository todoRepo;


	@Override
	public Todo createTodo(Todo todo) {
		return todoRepo.save(todo);
	}

	@Override
	public Todo updateTodo(Todo todo) {
		Optional<Todo> todoDB = this.todoRepo.findById(todo.getId());
		if(todoDB.isPresent()) {
			Todo todoUpdate=todoDB.get();
			todoUpdate.setId(todo.getId());
			todoUpdate.setLang(todo.getLang());
			todoUpdate.setMessage(todo.getMessage());
			todoRepo.save(todoUpdate);
			return todoUpdate;
		}else {
			throw new UserNotFound("Record Not Found" + todo.getId());

		}	
	
	}
	
	@Override
	public Optional < Todo > getEmployeeById(Integer id)
			throws ResourceNotFoundException {
		return todoRepo.findById(id);
	}

	@Override
	public Map<String, Boolean> deleteTodo(Integer id) throws ResourceNotFoundException {
		Todo employee;
		employee = todoRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not found for this id :: " + id));

		todoRepo.delete(employee);
		Map < String, Boolean > response = new HashMap <String, Boolean> ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


	@Override
	public List<Todo> getAllTodo() {
		 List<Todo> todos = new ArrayList<>();
		    todoRepo.findAll().forEach(todos::add);
		    return todos;
	}




}