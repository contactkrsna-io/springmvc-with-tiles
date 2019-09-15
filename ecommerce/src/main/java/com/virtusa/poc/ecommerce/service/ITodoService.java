package com.virtusa.poc.ecommerce.service;

import java.util.List;

import com.virtusa.poc.ecommerce.web.dto.*;

public interface ITodoService {

	
	public void addTodo(TodoDto todoDto);
	public void updateTodo(TodoDto todoDto);
	public List<TodoDto> listTodos();
	public TodoDto getTodoById(long id);
	public void removeTodo(long id);
}
