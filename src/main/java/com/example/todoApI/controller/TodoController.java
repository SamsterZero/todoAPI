package com.example.todoApI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.example.todoApI.model.request.Todo;
import com.example.todoApI.model.response.SuccessResponse;
import com.example.todoApI.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;

	@PostMapping("/AddTodo")
	public ResponseEntity<?> addTask(@RequestBody Todo todo) {
		System.out.println("Task : " + todo.getTask());
		return ResponseEntity.ok(todoService.addOrUpdateTask(todo));
	}

	@GetMapping("/TodoList")
	public ResponseEntity<?> getlist(Pageable pageable) {
		if (pageable.getPageNumber() < 0 || pageable.getPageSize() < 1) {
			throw new HttpClientErrorException(HttpStatusCode.valueOf(400));
		}
		return ResponseEntity.ok(todoService.getTaskList(pageable));
	}

	@GetMapping("/")
	public ResponseEntity<?> list(@RequestParam Long startId, @RequestParam Long endId, Pageable pageable) {
		if (startId < 0 || endId < 0) {
			throw new HttpClientErrorException(HttpStatusCode.valueOf(400));
		}
		System.out.println("SI : " + startId + "\nEI : " + endId);
		return ResponseEntity.ok(todoService.getTaskListBetween(startId, endId, pageable));
	}

	@PutMapping("/ChangeTodo")
	public ResponseEntity<?> updateTodo(@RequestBody Todo todo) {
		System.out.println("Task : " + todo.getTask());
		return ResponseEntity.ok(todoService.addOrUpdateTask(todo));
	}

	@DeleteMapping("/RemoveTodo")
	public ResponseEntity<?> removeTodo(@RequestParam Long id) {
		todoService.deleteTask(id);
		return ResponseEntity.ok(new SuccessResponse("Successfully Deleted Task with id : " + id));
	}
}