package com.virtusa.poc.ecommerce.persistence.dao;

import java.util.List;

import com.virtusa.poc.ecommerce.persistence.model.Todo;

public interface ITodoDao {

	
	public void addTodo(Todo todo);
	public void updateTodo(Todo todo);
	public List<Todo> listTodos();
	public Todo getTodoById(long id);
	public void removeTodo(long id);
}
