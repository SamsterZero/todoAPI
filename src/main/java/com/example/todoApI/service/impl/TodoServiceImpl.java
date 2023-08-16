package com.example.todoApI.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.todoApI.entity.TodoList;
import com.example.todoApI.model.request.Todo;
import com.example.todoApI.model.response.PageModel;
import com.example.todoApI.repository.TodoListRepo;
import com.example.todoApI.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoListRepo todoListRepo;

	@Override
	public TodoList addOrUpdateTask(Todo todo) {
		return todoListRepo.save(new TodoList(todo.getId(), todo.getTask()));
	}

	@Override
	public PageModel getTaskList(Pageable pageable) {
		Page<TodoList> page = todoListRepo.findAll(pageable.previousOrFirst());
		if (page.getContent().isEmpty()) {
			throw new NullPointerException("No Data Found");
		}
		return new PageModel(page.getContent(), page.getNumber() + 1, page.getTotalPages());
	}

	@Override
	public PageModel getTaskListBetween(Long startId, Long endId, Pageable pageable) {
		Page<TodoList> page = todoListRepo.findAllByIdBetween(startId, endId, pageable.previousOrFirst());
		if (page.getContent().isEmpty()) {
			throw new NullPointerException("No Data Found");
		}
		return new PageModel(page.getContent(), page.getNumber() + 1, page.getTotalPages());
	}

	@Override
	public void deleteTask(Long id) {
		todoListRepo.deleteById(id);
	}
}