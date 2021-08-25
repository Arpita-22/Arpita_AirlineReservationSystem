<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Passenger"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Passenger Info</title>
</head>
<body>
	<h1>Update Passenger Info</h1>


	<form:form class="passengerUpdateForm" action="updatePassenger"
		method="post" modelAttribute="passenger">

		<div id="passengerDetailsUpdated">
			<fieldset>
				<legend>Passenger# </legend>
				<form:label path="firstName" for="firstName">First Name</form:label>
				<form:input path="firstName" id="firstName${passenger.firstName}"
					type="text" name="firstName" placeholder="firstName"
					value="${passenger.firstName}" />
				<form:errors path="firstName" class="form-errors" />
				<br />

				<form:label path="lastName" for="lastName">Last Name</form:label>
				<form:input path="lastName" id="lastName${passenger.lastName}"
					type="text" name="lastName" placeholder="lastName"
					value="${passenger.lastName}" />
				<form:errors path="lastName" class="form-errors" />
				<br />

				<form:label path="email" for="email">Email</form:label>
				<form:input path="email" id="email${passenger.email}" type="email1"
					name="email" placeholder="email" value="${passenger.email}" />
				<form:errors path="email" class="form-errors" />
				<br />

				<form:label path="dateOfBirth" for="dateOfBirth">Date Of Birth</form:label>
				<form:input path="dateOfBirth"
					id="dateOfBirth${passenger.dateOfBirth}" type="date"
					name="dateOfBirth" placeholder="dateOfBirth"
					value="${passenger.dateOfBirth}" />
				<form:errors path="dateOfBirth" class="form-errors" />
				<br />

				<form:label path="gender" for="gender">Gender</form:label>
				<form:input path="gender" id="gender${passenger.gender}" type="text"
					name="gender" placeholder="gender" value="${passenger.gender}" />
				<form:errors path="gender" class="form-errors" />
				<br />

				<form:label path="personalId" for="personalId">Personal ID</form:label>
				<form:input path="personalId" id="personalId${passenger.personalId}"
					type="text" name="personalId" placeholder="personalId"
					value="${passenger.personalId}" />
				<form:errors path="personalId" class="form-errors" />
				<br />
			</fieldset>
		</div>


		<input type="submit" name="submit" value="Update" />

	</form:form>

</body>
</html>