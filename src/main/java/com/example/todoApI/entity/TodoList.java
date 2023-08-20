package com.example.todoApI.entity;

import java.time.LocalDateTime;

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
	private Long id;

	@Column(name = "Task")
	private String task;

	@Column(name = "Created_On")
	private LocalDateTime createdOn;

	@Column(name = "Updated_On")
	private LocalDateTime updatedOn;

	@Column(name = "Deleted_On")
	private LocalDateTime deletedOn;

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

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public LocalDateTime getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(LocalDateTime deletedOn) {
		this.deletedOn = deletedOn;
	}

	public TodoList(Long id, String task, LocalDateTime createdOn, LocalDateTime updatedOn, LocalDateTime deletedOn) {
		super();
		this.id = id;
		this.task = task;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.deletedOn = deletedOn;
	}

	public TodoList(String task, LocalDateTime creationDateTime) {
		super();
		this.task = task;
		this.createdOn = creationDateTime;
	}

	public TodoList(Long id, String task) {
		super();
		this.id = id;
		this.task = task;
	}

	public TodoList(String task) {
		super();
		this.task = task;
	}

	public TodoList() {
		super();
	}

	@Override
	public String toString() {
		return "TodoList [id=" + id + ", task=" + task + ", creationDateTime=" + createdOn + ", updationDateTime="
				+ updatedOn + ", deletionDateTime=" + deletedOn + "]";
	}
}