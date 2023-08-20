package com.example.todoApI.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.todoApI.entity.TodoList;
import com.example.todoApI.model.PageModel;
import com.example.todoApI.model.Todo;
import com.example.todoApI.repository.TodoListRepo;
import com.example.todoApI.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoListRepo todoListRepo;

	@Override
	public TodoList addTask(String newTask) {
		TodoList todo = new TodoList();
		todo.setTask(newTask);
		todo.setCreatedOn(LocalDateTime.now());
		return todoListRepo.save(todo);
	}

	@Override
	public PageModel getTaskList(Pageable pageable) {
		Page<TodoList> page = todoListRepo.findALLByDeletedOn(null, pageable.previousOrFirst());
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
	public TodoList UpdateTask(Todo todo) {
		Optional<TodoList> optionalTodo = todoListRepo.findById(todo.getId());
		if (optionalTodo.isPresent()) {
			TodoList todo2 = optionalTodo.get();
			todo2.setTask(todo.getTask());
			todo2.setUpdatedOn(LocalDateTime.now());
			return todoListRepo.saveAndFlush(todo2);
		}
		throw new NullPointerException("No record found with id : " + todo.getId());
	}

	@Override
	public TodoList deleteTask(Long id) {
		Optional<TodoList> optionalTodo = todoListRepo.findById(id);
		if (optionalTodo.isPresent()) {
			TodoList todo = optionalTodo.get();
			if (todo.getDeletedOn() == null) {
				todo.setDeletedOn(LocalDateTime.now());
				return todoListRepo.saveAndFlush(todo);
			}
			throw new IllegalArgumentException("Record with id " + id + " is already been deleted");
		}
		throw new NullPointerException("No record found with id : " + id);
	}
}