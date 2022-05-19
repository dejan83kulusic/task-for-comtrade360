package com.example.controller;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Todo;
import com.example.service.TodoService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@RestController
@RequestMapping("hello")
public class UserController {
    @Autowired
    private TodoService service;
	@GetMapping("/todos")
	public List < Todo > getAllEmployees() {
		return service.getAllTodo();
	}


	@GetMapping("/todos/{id}")

	public ResponseEntity < Todo > getEmployeeById(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		Todo todo = service.getEmployeeById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return ResponseEntity.ok().body(todo);
	}



	@RolesAllowed("ADMIN")
	@PostMapping("/todos")
	public Todo createEmployee(@Validated @RequestBody Todo todo) {
		return service.createTodo(todo);
	}

	@PutMapping("/todos/{id}")
	public ResponseEntity < Todo > updateEmployee(@PathVariable(value = "id") Integer id,
													  @Validated @RequestBody Todo todo) throws ResourceNotFoundException {
		todo.setId(id);
		return ResponseEntity.ok().body(service.updateTodo(todo));
	}

	@DeleteMapping("/todos/{id}")
	public Map< String, Boolean > deleteEmployee(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		return service.deleteTodo(id);
	}
}