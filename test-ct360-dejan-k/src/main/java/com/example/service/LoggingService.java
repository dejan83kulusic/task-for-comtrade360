package com.example.service;

import com.example.model.Todo;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoggingService {
    static HashMap<Integer, Todo> db = new HashMap<>();
    static {
        db.put(1, new Todo(1, "en", "Hello, world"));
        db.put(2, new Todo(2, "ba", "Zdravo svjete"));
    }
    public Todo getTodoById(Integer id) {
        return db.get(id);
    }

}
