package com.example.todoApI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TaskList")
public class TodoList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	Long id;

	@Column(name = "Task")
	String task;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public TodoList() {
		super();
	}

	public TodoList(String task) {
		super();
		this.task = task;
	}

	public TodoList(Long id, String task) {
		super();
		this.id = id;
		this.task = task;
	}

	@Override
	public String toString() {
		return "TodoList [id=" + id + ", task=" + task + "]";
	}
}