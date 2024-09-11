<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
/* General page styles */
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

/* Card container */
.card {
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 20px;
    max-width: 400px;
    width: 100%;
    text-align: center;
}

/* Title styling */
.card h2 {
    font-size: 24px;
    color: #333;
    margin-bottom: 20px;
}

/* Button styles */
button {
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
    width: 100%;
    margin-bottom: 10px;
}

button.create {
    background-color: #007aff;
    color: white;
}

button.create:hover {
    background-color: #005bb5;
}

button.login {
    background-color: #28a745;
    color: white;
}

button.login:hover {
    background-color: #218838;
}
</style>
</head>
<body>

    <div class="card">
        <h2>Hotel Management System</h2>
        <a href="createUser"><button class="create">Register User</button></a>
        <a href="login"><button class="login">Login</button></a>
    </div>

</body>
</html>
