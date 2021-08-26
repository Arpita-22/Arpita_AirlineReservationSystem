<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- <script src="javaScript/index.js" defer="defer"></script> -->
<title>Login</title>
<style>
body {
	background-image: url("images/Destination.jpg");
}

input[type=text], input[type=password], input[type=email] {
	width: 100%;
	padding: 20px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	background-color: rgb(228, 235, 236);
	font-size: 20px;
	text-align: center;
	color: black;
}

form {
	background-color: white;
	width: 50%;
	height: 50%;
	padding: 10px;
	margin: 76px -155px 0px 440px;
	box-shadow: 10px 5px 5px rgb(160, 154, 154);
}

label {
  font-size: 20px;
}

</style>
</head>
<body>
	<div>
		<nav>
			<a href="${pageContext.request.contextPath}/">Home</a>
		</nav>
		<p>${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
		<h1>Login</h1>
		<br />
		<form class="loginForm" action="./login" method="post">
			<label for="username">Username</label> 
			<input id="username" name="username" placeholder="username" type="text" />
			<label for="password">Password</label> <input id="passW" name="password" placeholder="Password" type="password" />
			<input type="submit" name="submit" value="login" />
		</form>
		<br /> <a href="./signUp">Sign Up</a> <br />


		<h1 id="loginForm-h1"></h1>
	</div>
</body>
</html>