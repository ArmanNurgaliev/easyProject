package com.example.easyproject.service;

import com.example.easyproject.entity.Todo;
import com.example.easyproject.entity.User;
import com.example.easyproject.model.TodoModel;
import com.example.easyproject.repository.TodoRepository;
import com.example.easyproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository todoRepository;
    private UserRepository userRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public TodoModel createTodo(Todo todo, Long userId) {
        User user = userRepository.findById(userId).get();
        todo.setUser(user);
        return TodoModel.toModel(todoRepository.save(todo));
    }

    public TodoModel completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).get();
        todo.setCompleted(!todo.isCompleted());
        return TodoModel.toModel(todoRepository.save(todo));
    }
}
