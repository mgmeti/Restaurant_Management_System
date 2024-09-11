<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
<style>
.order-card {
	border: 1px solid #ccc;
	border-radius: 8px;
	padding: 16px;
	margin-bottom: 16px;
	box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
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

.button {
	display: inline-block;
	padding: 8px 12px;
	text-decoration: none;
	background-color: #4CAF50;
	color: white;
	border-radius: 4px;
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
}

button.home:hover {
	background-color: #005bb5;
}
</style>
</head>
<body>

	<a href="home"><button class="home">Home</button></a>
	<h1>Customer Details</h1>

	<!-- Display Customer Details -->
	<div>
		<p>
			<strong>Name:</strong> ${customer.name}
		</p>
		<p>
			<strong>Phone:</strong> ${customer.phone}
		</p>
		<p>
			<strong>Email:</strong> ${customer.email}
		</p>
		<a href="editCustomer?id=${customer.id}" class="button">Edit
			Customer Details</a>
	</div>

	<hr>

	<!-- Display Order Count and Create Order Button -->
	<div>
		<p>Total Orders: ${ordersList.size()}</p>
		<a href="createOrder?customerId=${customer.id}" class="button">Create
			Order</a>
	</div>

	<hr>

	<!-- Display List of Orders -->
	<c:forEach var="order" items="${ordersList}">
		<div class="order-card">
			
			<p>
				<strong>Total:</strong> ${order.totalCost}
			</p>

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
		</div>
	</c:forEach>

</body>
</html>
