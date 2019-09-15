<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>


</head>
<body>

	
	
	<c:set var="req" value="${pageContext.request}" />
	<c:set var="url">${req.requestURL}</c:set>
	<c:set var="uri" value="${req.requestURI}" />
	<c:url var="saveOrUpdateTodoAction" value="/saveOrUpdateTodo"></c:url>
	

<div class="container">
	<form:form action="${saveOrUpdateTodoAction}" method="post" modelAttribute="todoForm">
		<!-- Create Form -->
		<fieldset class="border p-2">
   
		<c:if test="${empty todoForm.title}">
			<legend  class="w-auto">Create Todo</legend>

			<div class="form-group">
				<form:label path="title">Title</form:label> 
				<form:input class="form-control" placeholder="Title" type="text" value="" path="title" />
			</div>
			
			<div class="form-group">
				<form:label path="description">Description</form:label>
				<form:textarea class="form-control" placeholder="Description" path="description"/>
			</div>
			
			<button type="submit" class="btn btn-primary">Create Todo</button>
		
		</c:if>	
		
		
		<!-- Edit Form -->
		
		<c:if test="${!empty todoForm.title}">
			<legend  class="w-auto">Edit Todo</legend>
			
			<div class="form-group">	
				<form:label path="title">Title</form:label> 
				<form:input class="form-control" placeholder="Title" type="text" value="" path="title" /> 
			</div>
			
			<form:hidden path="id" />
			
			<div class="form-group">
				<form:label path="description">Description</form:label>
				<form:textarea type="textarea" class="form-control" placeholder="Description" path="description"/>
			</div>
			
			<button type="submit" class="btn btn-primary">Update Todo</button>
		</c:if>
		
		</fieldset>
		
	</form:form>
	

	<c:if test="${!empty listTodos}">
		
		<table class="table table-striped mt-3">
			<thead class="thead-dark">
				<tr>
					<th> Title </th>
					<th> Description </th>
					<th> Edit </th>
					<th> Delete </th>
				</tr>
			</thead>
	
			<tbody>
			 	<c:forEach items="${listTodos}" var="todo">
				<tr>
					<td>${todo.title}</td>
					<td>${todo.description}</td>
					<td><a href="<c:url value='/editTodo/${todo.id}' />">Edit</a> </td>
					<td><a href="<c:url value='/deleteTodo/${todo.id}' />">Delete</a> </td>
				</tr>
				</c:forEach>
			</tbody>		
		</table>
	
	</c:if>
	
	</div> <!-- Container End -->
</body>
</html>