package com.example.backenddictionnary.backend_dictionary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.Todo;

@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo getTodoById(Long id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Todo createTodo(Todo todo) {
        todo.setId(System.currentTimeMillis());
        todos.add(todo);
        return todo;
    }

    public Todo updateTodo(Long id, Todo todo) {
        Todo existingTodo = getTodoById(id);
        if (existingTodo == null) {
            return null;
        }
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setCompleted(todo.isCompleted());
        return existingTodo;
    }

    public void deleteTodoById(Long id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }
}
