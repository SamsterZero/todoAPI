package com.example.todoApI.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoApI.entity.TodoList;

public interface TodoListRepo extends JpaRepository<TodoList, Long> {

	Page<TodoList> findAllByIdBetween(Long startId, Long endId, Pageable pageable);
}