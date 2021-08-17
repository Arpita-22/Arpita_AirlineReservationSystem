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
<script src="javaScript/index.js" defer="defer"></script>
-->
<title>Login</title>
<style>
body {
	background-image: url("images/Destination.jpg");
}
</style>
</head>
<body>
	<div>
		<nav>
			<a href="${pageContext.request.contextPath}/">Home</a>
		</nav>
		<h1>Login Page</h1>
		<br />
		<form class="loginForm" action="checkUser" method="post">
			<label for="email">Email</label> <input id="email" name="email"
				placeholder="email" /> <label for="password">Password</label> <input
				id="passW" name="password" placeholder="Password" /> <input
				type="submit" name="submit" value="login" />
		</form>
		<br />
		<br />


		<%--    <br />
		<form class="loginForm" action="checkPassenger" method="post">
			<div>
				<label for="email-id">Email</label> 
				<input id="email-id" name="email" />
			</div>
			<div>
				<label for="password-id">Password</label>
				<input id="password-id" name="password" />
			</div>
			<div>
				<input type="submit" value="Login" />
			</div>
		</form>

		<br />
		<br /> --%>

		<h1 id="loginForm-h1"></h1>
	</div>
</body>
</html>