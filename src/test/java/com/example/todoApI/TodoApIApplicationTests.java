package com.example.todoApI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.todoApI.repository.TodoListRepo;

@SpringBootTest
class TodoApIApplicationTests {

	@Autowired
	TodoListRepo todoListRepo;

	@Test
	public void whenFindByIdBetween() {

	}

}
