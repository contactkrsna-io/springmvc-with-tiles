package com.virtusa.poc.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.poc.ecommerce.persistence.dao.ITodoDao;
import com.virtusa.poc.ecommerce.persistence.model.Todo;
import com.virtusa.poc.ecommerce.web.dto.TodoDto;


@Service
@Transactional
public class TodoServiceImpl implements ITodoService{
	
	
	private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
	
	private ITodoDao todoDao;
	
	public void setTodoDao(ITodoDao todoDao) {
		this.todoDao = todoDao;
	}

	@Override
	public void addTodo(TodoDto todoDto) {
		logger.info("TodoServiceImpl.addTodo()" );
		Todo todo = new Todo();
		todo.setTitle(todoDto.getTitle());
		todo.setDescription(todoDto.getDescription());
		todoDao.addTodo(todo);
	}

	@Override
	public void updateTodo(TodoDto todoDto) {
		logger.info("TodoServiceImpl.updateTodo()");
		Todo todoEntity = new Todo();
		todoEntity.setId(todoDto.getId());
		todoEntity.setTitle(todoDto.getTitle());
		todoEntity.setDescription(todoDto.getDescription());
		todoDao.updateTodo(todoEntity);
	}

	@Override
	public List<TodoDto> listTodos() {
		logger.info("TodoServiceImpl.listTodos()");
		List<Todo> todos = todoDao.listTodos();
		List<TodoDto> todoDtos = new ArrayList<>();
		for(Todo todoEntity : todos) {
			TodoDto todoDto = new TodoDto();
			todoDto.setId(todoEntity.getId());
			todoDto.setTitle(todoEntity.getTitle());
			todoDto.setDescription(todoEntity.getDescription());
			todoDtos.add(todoDto);
		}
		return todoDtos;
	}

	@Override
	public TodoDto getTodoById(long id) {
		logger.info("TodoServiceImpl.getTodoById()");
		TodoDto todoDto = new TodoDto();
		Todo todo = todoDao.getTodoById(id);
		todoDto.setId(todo.getId());
		todoDto.setTitle(todo.getTitle());
		todoDto.setDescription(todo.getDescription());
		return todoDto;
	}

	@Override
	public void removeTodo(long id) {
		logger.info("TodoServiceImpl.removeTodo()");
		todoDao.removeTodo(id);
		
	}

}
