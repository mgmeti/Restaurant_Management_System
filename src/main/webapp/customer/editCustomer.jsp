<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer Details</title>

<style>
/* General page styles */
body {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, sans-serif;
	background-color: #f7f7f7;
	color: #333;
	margin: 0;
	padding: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

/* Form container */
form {
	background-color: #ffffff;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	padding: 20px;
	max-width: 400px;
	width: 100%;
}

/* Form heading */
h1 {
	font-size: 24px;
	font-weight: 600;
	margin-bottom: 20px;
	text-align: center;
	color: #444;
}

/* Input fields */
input[type="text"], input[type="email"], input[type="number"] {
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	outline: none;
	transition: border-color 0.2s;
}

input[type="text"]:focus, input[type="email"]:focus, input[type="number"]:focus
	{
	border-color: #007aff; /* MacOS accent color */
}

/* Submit button */
input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007aff;
	border: none;
	border-radius: 4px;
	color: white;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #005bb5; /* Darker blue for hover effect */
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

button.home {
	background-color: #007aff;
	color: white;
	position: absolute;
	top: 20px;
	left: 20px;
}

button.home:hover {
	background-color: #005bb5;
}
</style>
</head>
<body>

	 <a href="menuList"><button class="home">Menu List</button></a>
	<form:form action="updateCustomer" modelAttribute="editCustomer">
		<h1>Update the customer details</h1>
		<form:input path="id" placeholder="Id" readonly="true" />
		<form:input path="name" placeholder="Name" />
		<form:input path="phone" placeholder="Phone"  />
		<form:input path="email" placeholder="Email"  />
		
		<input type="submit" value="Submit" />

	</form:form>

</body>
</html>