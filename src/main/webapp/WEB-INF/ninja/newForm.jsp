<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page import = "java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style>
	form{ display: inline; }
</style>
<title>New Ninja</title>
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<br><br>
		<div class="row">
			<div class="col-md-6">
				<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
			    
			    <div class="form-group">
			        <form:select path="dojo" class="form-control">
			        	<c:forEach var="dojo" items="${dojos}">
					        <form:option value="${dojo.id}"> ${dojo.getName()}</form:option>
					    </c:forEach>
			        </form:select>
			    </div>
			    
			    <div class="form-group">
			        <form:label path="firstName">First Name: </form:label>
			        <form:errors path="firstName" class="text-danger"/>
			        <form:input path="firstName" class="form-control"/>
			    </div>
			    
			    <div class="form-group">
			        <form:label path="lastName">Last Name: </form:label>
			        <form:errors path="lastName" class="text-danger"/>
			        <form:input path="lastName" class="form-control"/>
			    </div>
			    
			    <div class="form-group">
			        <form:label path="age">Age: </form:label>
			        <form:errors path="age" class="text-danger"/>
			        <form:input path="age" class="form-control" type="number"/>
			    </div>
	
			    <input type="submit" value="Create" class="btn btn-primary"/>
			</form:form>    
			</div>
		</div>
	</div>
</body>
</html>
