<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Successful</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.message-container {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.message-container h1 {
	color: #4CAF50;
	font-size: 24px;
	margin-bottom: 10px;
}

.message-container p {
	color: #333333;
	font-size: 16px;
	margin-bottom: 20px;
}

.message-container a {
	display: inline-block;
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s;
}

.message-container a:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="message-container">
		<h1>Registration Successful</h1>
		<p>Your data has been saved successfully!</p>
		<a href="home">Go to Login</a>
	</div>

</body>
</html>