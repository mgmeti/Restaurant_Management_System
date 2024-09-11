<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu List</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

body {
	padding: 20px;
	background-color: #f4f4f4;
	display: flex;
	flex-direction: column;
	align-items: center;
	min-height: 100vh;
}

h2 {
	margin-bottom: 20px;
	color: #333;
}

table {
	width: 80%;
	border-collapse: collapse;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
	overflow: hidden;
}

th, td {
	padding: 12px 20px;
	text-align: left;
}

th {
	background-color: #007bff;
	color: white;
	font-weight: bold;
}

td {
	background-color: #f9f9f9;
	color: #333;
}

tr:nth-child(even) td {
	background-color: #e9e9e9;
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

button:hover {
	background-color: #0056b3;
}

button.delete {
	background-color: #dc3545;
	color: white;
}

button.delete:hover {
	background-color: #c82333;
}

button.edit {
	background-color: #ffc107;
	color: white;
}

button.edit:hover {
	background-color: #e0a800;
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

	<h2>Menu </h2>
	<a href="admin"><button class="home">admin</button></a>
	<table border="2px" cellspacing="0" cellpadding="40" align="center">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CATEGORY</th>
			<th>PRICE</th>
			<th>DELETE</th>
			<th>EDIT</th>
		</tr>
		<c:forEach var="item" items="${items}">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.category}</td>
				<td>${item.price}</td>
				<td><a href="deleteItem?id=${item.id}"><button
							class="delete">Delete</button></a></td>
				<td><a href="editItem?id=${item.id}"><button class="edit">Edit</button></a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>