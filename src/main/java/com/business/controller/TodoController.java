/**
 * Handles HTTP requests and response
 */

package com.business.controller;

import com.business.model.Todo;
import com.business.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import java.util.List;
// import jakarta.validation.Valid;

// import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class TodoController {
    private String redirectTodo = "redirect:/";

    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }


    @GetMapping
    public String index(Model model){
        model.addAttribute("todos", todoRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "add-todo";
    }

    @PostMapping("/add")
    public String addTodo(Todo todo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-todo";
        }
        todoRepository.save(todo);
        return redirectTodo;
    }


    @GetMapping("/delete")
    public String deleteTodo(@RequestParam Long id) {
        todoRepository.deleteById(id);
        return redirectTodo;
    }
}