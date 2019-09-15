package com.virtusa.poc.ecommerce.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.virtusa.poc.ecommerce.persistence.model.Todo;

@Repository
public class TodoDaoImpl implements ITodoDao {
	
	
	private static final Logger logger = LoggerFactory.getLogger(TodoDaoImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void addTodo(Todo todo) {
		logger.info("TodoDaoImpl.addTodo()"+sessionFactory);
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(todo);
	}

	@Override
	public void updateTodo(Todo todo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(todo);
	}

	@Override
	public List<Todo> listTodos() {
		logger.info("TodoDaoImpl.listTodos()");
		Session session = this.sessionFactory.getCurrentSession();
		List<Todo> todoList = session.createQuery("from Todo").list();
		for(Todo todo : todoList){
			logger.info("Todo List::"+todo);
		}
		return todoList;
	}

	@Override
	public Todo getTodoById(long id) {
		logger.info("TodoDaoImpl.getTodoById()");
		Session session = this.sessionFactory.getCurrentSession();
		Todo todo = (Todo) session.load(Todo.class, new Long(id));
		
		return todo;
	}

	@Override
	public void removeTodo(long id) {
		logger.info("TodoDaoImpl.removeTodo()");
		Session session = this.sessionFactory.getCurrentSession();
		Todo todo = (Todo) session.load(Todo.class, new Long(id));
		if(null != todo){
			session.delete(todo);
		}
	}

}
