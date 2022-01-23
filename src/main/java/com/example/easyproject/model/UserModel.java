package com.example.easyproject.model;

import com.example.easyproject.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {

    private Long id;
    private String username;
    private List<TodoModel> todos;

    public static UserModel toModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setUsername(user.getUsername());
        userModel.setTodos(user.getTodos().stream().map(TodoModel::toModel).collect(Collectors.toList()));
        return userModel;
    }

    public UserModel() {
    }

    public List<TodoModel> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoModel> todos) {
        this.todos = todos;
    }

    public UserModel(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
