package com.example.todoList.controller;

import com.example.todoList.model.Todo;
import com.example.todoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {
    private TodoService serve;

    public TodoService getServe() {
        return serve;
    }
    @Autowired
    public void setServe(TodoService serve) {
        this.serve = serve;
    }
    //Home page to show all tasks
    @GetMapping("/")
    public String showTodos(Model model){
        List<Todo> todos=serve.getAllTodos();
        model.addAttribute("todos",todos);
        model.addAttribute("todo",new Todo());
        return "todo";
    }

    //Add new Todo
    @PostMapping("/add")
    public String addTodo(@RequestParam("title") String title){
        serve.addTodo(title);
        return "redirect:/";
    }

    //mark todo as completed
    @GetMapping("/complete/{id}")
    public String completeTodo(@PathVariable int id){
        serve.completedTodo(id);
        return "redirect:/";
    }

    //delete todo
    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id){
        serve.deleteTodo(id);
        return "redirect:/";
    }
}
