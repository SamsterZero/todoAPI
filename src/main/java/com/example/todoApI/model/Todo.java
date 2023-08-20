package com.example.todoApI.model;

public class Todo {

	private Long id;

	private String task;

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Todo(String task) {
		super();
		this.task = task;
	}

	public Todo(Long id, String task) {
		super();
		this.id = id;
		this.task = task;
	}

	public Todo() {
		super();
	}

	@Override
	public String toString() {
		return "Todo [task=" + task + "]";
	}
}