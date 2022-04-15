package com.example.controller;

import com.example.model.Todo;
import com.example.service.TodoService;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
    @RolesAllowed("USER")
    @GetMapping("/todos")
	public ResponseEntity<List<Todo>> getAllProducts() {
		return ResponseEntity.ok().body(service.getAllTodo());
	}
    @RolesAllowed("USER")
	@GetMapping("/todos/{id}")
	public ResponseEntity<Optional<Todo>> getAllUsers(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.findOne(id));
	}
    @RolesAllowed("ADMIN")
	@PostMapping("/todos")
	public ResponseEntity<Todo> createProduct(@RequestBody Todo todo) {
		return ResponseEntity.ok().body(service.createTodo(todo));
	}
	
    @RolesAllowed("USER")
	@PutMapping("/todos/{id}")
	public ResponseEntity<Todo> updatUser(@PathVariable Integer id,@RequestBody Todo todo) {
		todo.setId(id);
		return ResponseEntity.ok().body(service.updateTodo(todo));
	}
	/*
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
		this.productService.deleteProcut(id);
		return (ResponseEntity<Product>) ResponseEntity.status(HttpStatus.OK);
		
		*/
    @RolesAllowed("USER")
    @DeleteMapping("/todos/{id}")
	public HttpStatus deleteProduct(@PathVariable Integer id){
		this.service.deleteTodo(id);
		return HttpStatus.OK;
	}
	
  
 
  
}
