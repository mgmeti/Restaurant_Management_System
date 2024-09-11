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


button.addItem {
    background-color: #28a745;
    color: white;
}

button.addItem:hover {
    background-color: #218838;
}

/* Style for nested table */
table.nested-table {
	margin: 0 auto;
	width: 100%;
	border-collapse: collapse;
}

table.nested-table th, table.nested-table td {
	padding: 8px;
	text-align: left;
	border: 1px solid #ddd;
}

table.nested-table th {
	background-color: #007bff;
	color: white;
}

table.nested-table td {
	background-color: #f9f9f9;
}

/* Style for bold text in menu rows */
.menu-id-name {
	font-weight: bold;
}
</style>
</head>
<body>

	<h2>Menu List</h2>
	<a href="admin"><button class="home">admin</button></a>
	<table border="2px" cellspacing="0" cellpadding="10" align="center">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="menu" items="${menuList}">
			<!-- Menu row -->
			<tr>
				<td class="menu-id-name">${menu.id}</td>
				<td class="menu-id-name">${menu.name}</td>
				<td>
					<a href="deleteMenu?id=${menu.id}"><button class="delete">Delete</button></a>
					<a href="editMenu?id=${menu.id}"><button class="edit">Edit</button></a>
					<a href="addItemToMenu?id=${menu.id}"><button class="addItem">Add New Item</button></a>
				</td>
			</tr>
			<!-- Nested table for items -->
			<tr>
				<td colspan="3">
					<!-- Nested table for items -->
					<table class="nested-table" border="0" cellspacing="0" cellpadding="5" align="center">
						<tr>
							<th>Item ID</th>
							<th>Item Name</th>
							<th>Category</th>
							<th>Price</th>
							<th>Actions</th>
						</tr>
						<c:forEach var="item" items="${menu.getItems()}">
							<tr>
								<td>${item.id}</td>
								<td>${item.name}</td>
								<td>${item.category}</td>
								<td>${item.price}</td>
								<td>
									<a href="deleteItemOfMenu?itemId=${item.id}&menuId=${menu.id}"><button class="delete">Delete</button></a>
									<a href="editItemOfMenu?itemId=${item.id}&menuId=${menu.id}"><button class="edit">Edit</button></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
