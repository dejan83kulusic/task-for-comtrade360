package com.example.service;

import com.example.exception.UserNotFound;
import com.example.model.Todo;
import com.example.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public  class TodoerviceImpl implements TodoService {

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
	public Optional<Todo> findOne(Integer id) {
		Optional<Todo> todoDB = this.todoRepo.findById(id);
		if(todoDB.isPresent()) {
			return todoRepo.findById(id);
		}else {
			throw new UsernameNotFoundException("Record not found" + id);
		}
	}
	

	@Override
	public List<Todo> getAllTodo() {
		 List<Todo> todos = new ArrayList<>();
		    todoRepo.findAll().forEach(todos::add);
		    return todos;
	}


	@Override
	public void deleteTodo(Integer todoId) {
		Optional<Todo> todoDb=this.todoRepo.findById(todoId);
		if(todoDb.isPresent()) {
			this.todoRepo.delete(todoDb.get());
		}else {
			throw new UserNotFound("Record Not Found" + todoId);

		}
	}

	

	
	

}