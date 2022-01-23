package com.example.easyproject.model;

import com.example.easyproject.entity.Todo;

public class TodoModel {
    private Long id;
    private String title;
    private boolean complete;

    public static TodoModel toModel(Todo todo) {
        TodoModel todoModel = new TodoModel();
        todoModel.setId(todo.getId());
        todoModel.setTitle(todo.getTitle());
        todoModel.setComplete(todo.isCompleted());

        return todoModel;
    }

    public TodoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
