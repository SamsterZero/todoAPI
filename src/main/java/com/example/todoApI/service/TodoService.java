package com.example.todoApI.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.todoApI.entity.TodoList;
import com.example.todoApI.model.PageModel;
import com.example.todoApI.model.Todo;

@Service
public interface TodoService {

	TodoList addTask(String todo);

	TodoList UpdateTask(Todo todo);

	PageModel getTaskList(Pageable pageable);

	PageModel getTaskListBetween(Long startId, Long endId, Pageable pageable);

	TodoList deleteTask(Long id);

}