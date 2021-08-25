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
<title>Sign Up</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Dancing+Script&display=swap')
	;

body {
	background-image: url("images/source.jpg");
}

a {
	color: rgb(182, 72, 8);
	background: none;
}

input[type=submit] {
	background-color: rgb(226, 150, 106);
}

h1 {
	font-family: 'Dancing Script', cursive;
}

.form-errors {
	color: red;
}

.signUpForm {
	width: 50%;
	height: 90%;
}
</style>
</head>

<body>
	<div>
		<nav>
			<a href="${pageContext.request.contextPath}/">Home</a>
		</nav>
		<h1 style="color: rgb(109, 42, 4)">Sign up</h1>

		<form:form class="signUpForm" action="createUser" method="post"
			modelAttribute="user">

			<form:label path="firstName" for="firstName">First Name</form:label>
			<form:input path="firstName" id="firstName" type="text"
				name="firstName" placeholder="firstName" />
			<form:errors path="firstName" class="form-errors" />
			<br />

			<form:label path="lastName" for="lastName">Last Name</form:label>
			<form:input path="lastName" id="lastName" type="text" name="lastName"
				placeholder="lastName" />
			<form:errors path="lastName" class="form-errors" />
			<br />

			<form:label path="email" for="email">Email</form:label>
			<form:input path="email" id="email" type="text" name="email"
				placeholder="email" />
			<form:errors path="email" class="form-errors" />
			<br />
			
			<form:label path="username" for="username">Username</form:label>
			<form:input path="username" id="username" type="text" name="username"
				placeholder="username" />
			<form:errors path="username" class="form-errors" />
			<br />

			<form:label path="password" for="password">Password</form:label>
			<form:input path="password" id="pass" type="password" name="password"
				placeholder="Password" />
			<form:errors path="password" class="form-errors" />
			<br />

			<input type="submit" name="submit" value="signUp" />
		</form:form>
		<br />
		<br />


		<h1 id="signUp-h1"></h1>
		<%-- <% if (request.getAttribute("error") != null ){
			out.print("User already exists");
		}
			%>
 --%>
	</div>
</body>

</html>