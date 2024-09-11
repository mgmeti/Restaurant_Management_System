<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Menu</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	padding: 20px;
}

.menu-container {
	max-width: 600px;
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #333;
}

form {
	margin-top: 20px;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007aff;
	color: white;
	border: none;
	border-radius: 4px;
	font-size: 16px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #005bb5;
}

a {
	text-decoration: none;
}

button {
	padding: 8px 12px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 14px;
	transition: background-color 0.3s ease;
}

button.admin {
	background-color: #007aff;
	color: white;
}

button.admin:hover {
	background-color: #005bb5;
}
</style>
</head>
<body>
	
	<a href="admin"><button class="admin">admin</button></a>
	<div class="menu-container">
		<h1>Create Menu</h1>

		<!-- Spring Form to add a new menu -->
		<form:form action="saveMenu" modelAttribute="menu">
			<form:input type="text" path="name"  placeholder="Enter menu name" />
			
			<input type="submit" value="Save Menu" />
		</form:form>

	</div>

</body>
</html>
