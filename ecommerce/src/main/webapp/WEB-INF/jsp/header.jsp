<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<nav class="navbar navbar-expand-md navbar-light bg-light">
    <a href="#" class="navbar-brand">
        <img src='<c:url value="/static/images/virtusa-logo.png" />' height="28" alt="Logo">
    </a>
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav">
            <a href="#" class="nav-item nav-link active">Home</a>
            <a href="#" class="nav-item nav-link">Profile</a>
            <a href="#" class="nav-item nav-link">Messages</a>
        </div>
        <div class="navbar-nav ml-auto">
        	<a href="#" class="nav-item nav-link">Howdy, RK</a>
            <a href="#" class="nav-item nav-link">SignOut</a>
        </div>
    </div>
</nav>