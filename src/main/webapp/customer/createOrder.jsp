<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create order </title>
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

tr td {
	background-color: #e9e9e9;
}


.order-table {
	width: 100%;
	margin-top: 8px;
}

.order-table th, .order-table td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
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

button.addToOrderCart {
	background-color: #ffc107;
	color: white;
}

button.addToOrderCart:hover {
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
<a href="customerHome?customerId=${customerId}"><button class="home">Customer Home</button></a>
	<h1>Create order</h1>
	<!-- Order Details Table -->
	<table class="order-table">
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${order.products}">
				<tr>
					<td>${product.name}</td>
					<td>${product.quantity}</td>
					<td>${product.price}</td>
					<td>${product.price * product.quantity}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<br>

	<h1>Items Available in Menu</h1>
	<table border="2px" cellspacing="0" cellpadding="40" align="center">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CATEGORY</th>
			<th>PRICE</th>
			<th>QUANTITY</th>
			<th>ACTION</th>
		</tr>
		<c:forEach var="item" items="${items}">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.category}</td>
				<td>${item.price}</td>
				<td><input type="number" name="quantity"
					class="quantity" min="0" value="0" /></td>
				<td><a
					href="addItemToOrder?customerId=${customerId}&orderId=${order.id}&itemId=${item.id}"><button
							class="addToOrderCart">Add to Cart</button></a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>