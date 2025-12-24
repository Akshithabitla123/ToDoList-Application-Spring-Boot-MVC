package com.example.todoList.service;


import com.example.todoList.model.Todo;
import com.example.todoList.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepo repo;

    public TodoRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(TodoRepo repo) {
        this.repo = repo;
    }

    public void addTodo(String title){
        repo.save(title);
    }
    public void completedTodo(int id){
        repo.markCompleted(id);
    }
    public void deleteTodo(int id){
        repo.delete(id);
    }
    public List<Todo> getAllTodos(){
        return repo.findAll();
    }
}
