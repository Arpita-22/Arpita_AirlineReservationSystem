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

/* input[type=password],input[type=email]{
    width: 100%;
    padding: 20px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    background-color:rgb(228, 235, 236);
    font-size: 20px;
    text-align: center;
    color: lightgray;
} */


input[type=password],input[type=email]{
   width: 100%; /* Full width */
  padding: 12px; /* Some padding */ 
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; /* Bottom margin */
  resize: vertical
}





</style>
</head>
<body>
	<div>
		<nav>
			<a href="${pageContext.request.contextPath}/">Home</a>
		</nav>
		<p>${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
		<h1>Login Page</h1>
		<br />
		<form class="loginForm" action="./login" method="post">
			<label for="username">Username</label> 
			<input id="username" name="username"placeholder="username" type="text" /> 
				<label for="password">Password</label> <input
				id="passW" name="password" placeholder="Password" type="password" /> <input
				type="submit" name="submit" value="login" />
		</form>
		<br />
		<a href="./signUp">Sign Up</a>
		<br />
		<%-- 	<% if (session.getAttribute("User") == null ){
			out.print("User does not exist");
		}
			%> --%>


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