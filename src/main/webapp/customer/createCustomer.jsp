<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Customer</title>
<style>
.readonly {
	background-color: #f0f0f0;
}
</style>
</head>
<body>

	<h1>Create Customer</h1>

	<!-- Form to capture customer details -->
	<form:form modelAttribute="customer" action="saveCustomer"
		method="post">

		<!-- Name (Read-Only) -->
		<div>
			<label for="name">Name:</label>
			<form:input path="name" value="${user.name}" />
		</div>

		<!-- Email (Read-Only) -->
		<div>
			<label for="email">Email:</label>
			<form:input path="email" value="${user.email}" />
		</div>

		<!-- Password (Read-Only) -->
		<div>
			<label for="password">Password:</label>
			<form:input path="password" value="${user.password}" />
		</div>

		<!-- Phone Number (Editable) -->
		<div>
			<label for="phone">Phone:</label>
			<form:input path="phone" />
		</div>

		<!-- Submit Button -->
		<div>
			<button type="submit">Save Customer</button>
		</div>

	</form:form>

</body>
</html>
