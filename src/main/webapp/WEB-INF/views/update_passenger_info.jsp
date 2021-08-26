<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Passenger"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Passenger Info</title>
<link rel="stylesheet" type="text/css" href="css/passengerInfo.css"> 
</head>
<style>
body{
  background: linear-gradient(to right, #696969 0%, #C0C0C0 100%);
}
passengerUpdateForm {
	width:200px;
    padding:20px;
}

* {
  box-sizing: border-box;
}


 input[type=text], input[type=email], input[type=date]{
	  padding:10px;
      margin:10px 0;
      box-shadow:0 0 15px 4px rgba(0,0,0,0.06);
      border-radius:10px;
      width:70% ;
      height: 40px;
     flex: 0 0 200px;
    margin-left: 10px;
}

input[type=submit], input[type=button]{
	width: 30%;
	height: 30%;
	margin-top: 20px;
} 

input {
  height: 50px;
  flex: 0 0 200px;
  margin-left: 10px;
  
}

label {
  display: inline-block;
  flex-direction: column;
  justify-content: flex-end;
  text-align: left;
  width: 100px;
  line-height: 26px;
  margin-bottom: 10px;
  font-size: 18px;
}



.border-customized-input {
   border: 2px solid #eee;
}

.border-bottom-input {
  border:0;
  border-bottom:1px solid #eee;
}

 form{
	background: linear-gradient(to right, #696969 0%, #C0C0C0 100%);
	width: 50%;
	height: 80%;
	padding: 0px;
	margin: 0px 0px 0px 417px;	
} 

fieldset{
	width: 100%;
	margin-bottom:10px;
	border: none;
}

#removePax {
	color: red;
	background-color: transparent;
	width: 150px;
	border: none;
	font-weight: bolder;
	margin: 0 0 0 450px;
}
</style>
<body>	
	<h1 style="text-align:center">Update Passenger Info</h1>


	<form:form class="passengerUpdateForm" action="updatePassenger"
		method="post" modelAttribute="passenger">

		<div id="passengerDetailsUpdated">
			<fieldset>
				<legend><h3>Passenger details</h3></legend>
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
				<form:input path="email" id="email${passenger.email}" type="email"
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