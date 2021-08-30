<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Passenger"%>
<%@ page
	import="org.arpita.airlinereservationsystem.models.PassengerList"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passenger Info</title>
<script src="javaScript/passenInfo.js" defer="defer"></script>
<!-- <link rel="stylesheet" type="text/css" href="css/style.css">  -->
<link rel="stylesheet" type="text/css" href="css/passengerInfo.css"> 
</head>
<style>
body{
  
 background-image: url("images/nasaMap.jpg");
  background-size: 1500px 1000px;
  background-repeat: no-repeat; 
}
</style>
<body>
	 <%@include file="home_link.html"  %> 
	 
	<h1 style="color: rgb(109, 42, 4); text-align:center;">Passenger Info</h1>
	
	<form:form class="passengerSignUpForm" action="createPassenger"
		method="post" modelAttribute="passengerList">

		<div id="passengerDetails">
		   <fieldset>
			<legend><h3>Passenger details</h3></legend>
			<form:label path="passengerList[0].firstName" for="firstName0">First Name</form:label>
			<form:input path="passengerList[0].firstName" id="firstName0"
				type="text" name="firstName" placeholder="firstName" value="test" />
			<form:errors path="passengerList[0].firstName" class="form-errors" />
			<br />

			<form:label path="passengerList[0].lastName" for="lastName0">Last Name</form:label>
			<form:input path="passengerList[0].lastName" id="lastName0"
				type="text" name="lastName" placeholder="lastName" value="test" />
			<form:errors path="passengerList[0].lastName" class="form-errors" />
			<br />

			<form:label path="passengerList[0].email" for="email0">Email</form:label>	
			<form:input path="passengerList[0].email" id="email0" type="email"
				name="email" placeholder="email" value="test@test.com" />
			<form:errors path="passengerList[0].email" class="form-errors" />
			<br />

			<form:label path="passengerList[0].dateOfBirth" for="dateOfBirth0">Date Of Birth</form:label>
			<form:input path="passengerList[0].dateOfBirth" id="dateOfBirth0"
				type="date" name="dateOfBirth" placeholder="dateOfBirth" />
			<form:errors path="passengerList[0].dateOfBirth" class="form-errors" />
			<br />

			<form:label path="passengerList[0].gender" for="gender0">Gender</form:label>
			<form:input path="passengerList[0].gender" id="gender0" type="text"
				name="gender" placeholder="gender" />
			<form:errors path="passengerList[0].gender" class="form-errors" />
			<br />

			<form:label path="passengerList[0].personalId" for="personalId0">Personal ID</form:label>
			<form:input path="passengerList[0].personalId" id="personalId0"
				type="text" name="personalId" placeholder="personalId" />
			<form:errors path="passengerList[0].personalId" class="form-errors" />
			<br />
			</fieldset>
		</div>

		<input type="button" id="btnAddd" value="Add Passenger" onclick="addPassenger()" />

		<input type="submit" name="submit" value="Confirm Passengers" />
	</form:form>

</body>
</html>