package com.example;

import com.example.model.Todo;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpringRestClient {

    private static final String GET_TODOS_ENDPOINT_URL = "http://localhost:8080/hello/todos";
    private static final String GET_TODO_ENDPOINT_URL = "http://localhost:8080/hello/todos/{id}";
    private static final String CREATE_TODO_ENDPOINT_URL = "http://localhost:8080/hello/todos";
    private static final String UPDATE_TODO_ENDPOINT_URL = "http://localhost:8080/hello/todos/{id}";
    private static final String DELETE_TODO_ENDPOINT_URL = "http://localhost:8080/hello/todos/{id}";
    private static RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        SpringRestClient springRestClient = new SpringRestClient();

        // Step1: first create a new employee
        springRestClient.createTodo();

        // Step 2: get new created employee from step1
        springRestClient.getTodo();

        // Step3: get all employees
        springRestClient.getAllTodos();

        // Step4: Update employee with id = 1
        springRestClient.updateTodo();

        // Step5: Delete employee with id = 1
        springRestClient.deleteTodo();
    }

    private void getAllTodos() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity< String > entity = new HttpEntity < String > ("parameters", headers);

        ResponseEntity< String > result = restTemplate.exchange(GET_TODOS_ENDPOINT_URL, HttpMethod.GET, entity,
                String.class);

        System.out.println(result);
    }

    private void getTodo() {

        Map< String, String > params = new HashMap< String, String >();
        params.put("id", "1");

        RestTemplate restTemplate = new RestTemplate();
        Todo result = restTemplate.getForObject(GET_TODO_ENDPOINT_URL, Todo.class, params);

        System.out.println(result);
    }

    private void createTodo() {

        Todo newTodo = new Todo(1, "eng", "Hallo World");

        RestTemplate restTemplate = new RestTemplate();
        Todo result = restTemplate.postForObject(CREATE_TODO_ENDPOINT_URL, newTodo, Todo.class);

        System.out.println(result);
    }

    private void updateTodo() {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", "1");
        Todo updateTodo = new Todo(2, "ba", "dravo Svjete");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(UPDATE_TODO_ENDPOINT_URL, updateTodo, params);
    }

    private void deleteTodo() {
        Map < String, Integer > params = new HashMap < String, Integer > ();
        params.put("id", 1);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(DELETE_TODO_ENDPOINT_URL, params);
    }
}