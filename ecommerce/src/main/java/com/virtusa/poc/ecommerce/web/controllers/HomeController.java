package com.virtusa.poc.ecommerce.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtusa.poc.ecommerce.service.ITodoService;
import com.virtusa.poc.ecommerce.web.dto.TodoDto;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private ITodoService todoService;
	
	@Autowired(required = true)
	@Qualifier(value = "todoService")
	public void setTodoService(ITodoService todoService) {
		this.todoService = todoService;
	}
	
	
	@GetMapping(value = "/")
	public String homePage(@ModelAttribute("todoForm") TodoDto todo, Model model) {
		logger.info("HomeController.homePage()");
		model.addAttribute("listTodos", todoService.listTodos());
		return "home";
	}
	
	@GetMapping(value = "/listTodos")
	public String listTodos(Model model) {
		logger.info("HomeController.listTodos()");
		model.addAttribute("todoForm", new TodoDto());
		model.addAttribute("listTodos", todoService.listTodos());
		return "home";
	}

	
	@PostMapping(value = "/saveOrUpdateTodo")
	public String submit(@ModelAttribute("todoForm")TodoDto todoDto, 
		      BindingResult result, ModelMap model) {
		 logger.info("HomeController.submit()"+todoDto.getId() );
        if(todoDto.getId() == 0) {
        	//create
        	todoService.addTodo(todoDto);
        }
        else {
        	//update
        	todoService.updateTodo(todoDto);
        }
		return "redirect:/listTodos";
	}
	
	
	@GetMapping(value = "/editTodo/{id}")
	public String editTodo(@PathVariable("id") long id, Model model) {
		logger.info("HomeController.editTodo()");
		model.addAttribute("todoForm",todoService.getTodoById(id));
		model.addAttribute("listTodos", todoService.listTodos());
		return "home";
	}
	
	@GetMapping(value = "/deleteTodo/{id}")
	public String deleteTodo(@PathVariable("id") long id, Model  model) {
		logger.info("HomeController.deleteTodo()");
		todoService.removeTodo(id);
		model.addAttribute("listTodos", todoService.listTodos());
		return "home";
	}

}
