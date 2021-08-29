<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.User"%>
<%@ page
	import="org.springframework.security.core.userdetails.UserDetails"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Airline Reservation System</title>
</head>
<style>
/* body {
	background-color: rgb(198, 218, 176);
} */

input[type=submit] {
	background-color: dodgerblue;
	color: white;
	height: 80%;
	width: 20%;
	margin: 0 0 0 80px;
}

select {
	background: white;
	width: 200px;
	padding: 2px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 15px;
	font-weight: 600;
	color: grey;
	line-height: 2;
	border: 1px solid black;
	border-radius: 0;
	margin-top: -200px;
	height: 100px;
	-webkit-appearance: none;
	height: 30px;
}

input[type=date] {
	width: 200px;
	line-height: 2;
	margin-top: -200px; 
}

.container-body {
	display: flex;
}

#navi, #search {
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 0;
}

#search {
	z-index: 10;
}

footer {
	width: 100%;
	height: 10%;
	position: relative;
	clear: both;
	z-index: 10;
	margin: 700px 0 0 0;
}

label{
  font-size: 20px;
  margin-left: 40px;
}


</style>

<body>
	<div class="main-container">
		<div class="container-body">
			<div id="navi">
			     <img src="images/northernLights.jpg" class="img-northern-lights" >
				<img src="images/AirPlane.jpg" class="img-airplane">
				<img src="images/california.jpg" class="img-california">
			</div>
			<div id="search">
				<h2 id="main-container-item">Fly with us</h2>
				<jsp:include page="navbar.jsp" />


				<h3 style="color:dodgerblue; margin-left: 40px;">Search Flights</h3>

				<form action="${pageContext.request.contextPath}/search"
					method="post">
					<!-- For Future Use -->
					<label for="state" style="color:dodgerblue;">Leaving From</label> <select
						class="select-state" name="stateFrom" id="state-leaving">
						<option value="seattle">Seattle</option>
						<option value="Denver">Denver</option>
						<option value="Boston">Boston</option>
						<option value="California">California</option>
					</select> <label for="state" style="color: dodgerblue;" id="label-going-to">Going To</label> <select
						class="select-state" name="stateTo" id="state-going">
						<option value="seattle">Seattle</option>
						<option value="Denver">Denver</option>
						<option value="California">California</option>
						<option value="boston">Boston</option>
					</select> 
					<br /><br />
					<label for="depart" style="color: dodgerblue;">Departing</label> <input
						class="depart" type="date" name="depart" min="2021-08-26" max="2021-08-26" /> <label
						for="returning" style="color: dodgerblue;">Returning</label> <input
						class="return" type="date" name="returning" min="2021-08-26" max="2021-08-26" />
						<br /><br />
					<input type="submit" name="submit" value="search"
						onSubmit="${pageContext.request.contextPath}/search" />

				</form>
			</div>
		</div>
	</div>
	<div>
		<footer> @Copyright Reserved </footer>
	</div>

</body>

</html>