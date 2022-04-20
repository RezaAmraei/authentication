<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    		<%@ page isErrorPage="true" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
		<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Register</h1>
	<form:form action="/register" method = "post" modelAttribute="newUser">
		<p>
			<form:label path="userName">User Name:</form:label>
			<form:errors path="userName"/>
			<form:input path="userName"/>
		</p>
		
		<p>
			<form:label path="email">Email:</form:label>
			<form:errors path="email"/>
			<form:input path="email"/>	
		</p>
		
		<p>
			<form:label path="password">Password:</form:label>
			<form:errors path="password"/>
			<form:input path="password"/>
		</p>
		
		<p>
			<form:label path="confirm">Confirm Password</form:label>
			<form:errors path="confirm"/>
			<form:input path="confirm"/>
		</p>
		<input type="submit" />
	</form:form>
	
	<h1>Login</h1>
		<form:form action="/login" method = "post" modelAttribute="newLogin">
		<p>
			<form:label path="email">Email:</form:label>
			<form:errors path="email"/>
			<form:input path="email"/>
		</p>
		
		<p>
			<form:label path="password">Password:</form:label>
			<form:errors path="password"/>
			<form:input path="password"/>	
		</p>
		
		<input type="submit" />
	</form:form>
</body>
</html>