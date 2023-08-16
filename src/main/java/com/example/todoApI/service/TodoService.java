package com.example.todoApI.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.todoApI.entity.TodoList;
import com.example.todoApI.model.request.Todo;
import com.example.todoApI.model.response.PageModel;

@Service
public interface TodoService {

	TodoList addOrUpdateTask(Todo todo);

	PageModel getTaskList(Pageable pageable);

	PageModel getTaskListBetween(Long startId, Long endId, Pageable pageable);

	void deleteTask(Long id);

}