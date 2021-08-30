<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Booking"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Flight"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="javaScript/index.js" defer="defer"></script>
<link rel="stylesheet" type="text/css" href="css/search.css" media="all">

<title>Flight</title>
<style>
table {
	margin-top: 50px;
}

body {
	/* background-color: rgb(200, 230, 240); */
	/* background: linear-gradient(to right, #696969 0%, #C0C0C0 100%); */
	background-image: url("images/worldmap.jpg");
}

.link-button {
	background: none;
	border: none;
	color: blue;
	text-decoration: underline;
	cursor: pointer;
	font-size: 1em;
	font-family: serif;
}

.link-button:focus {
	outline: none;
}

.link-button:active {
	color: red;
}

table {
	margin-left: auto;
	margin-right: auto;
}

a{
margin-left: 40px;
color: #556B2F;
}

thead{
  background-color: #556B2F;
}


</style>
</head>

<body>
	<div>
		 <%@include file="home_link.html"  %> 

		<br />
		<table border="1" borderColor="gray" height="80%" width="80%" id="hiddenfield">
		<caption style="text-align:center;color:#556B2F;">List of All Flights</caption>
			<thead>
				<tr>
					<th>Origin</th>
					<th>Destination</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Flight Number</th>
					<th>Price</th>
					<th>Booking</th>
				</tr>
			</thead>
			<tbody>
				<%
				Iterable<Flight> flights = (Iterable<Flight>) request.getAttribute("selectedFlights");
				for (Flight flight : flights) {
				%>
				<form method="post" action="createBooking" class="inline"
					method="post">

					<tr>
						<td><%=flight.getSource()%></td>
						<td><%=flight.getDestination()%></td>
						<td><%=flight.getArrivalTime()%></td>
						<td><%=flight.getDepartureTime()%></td>
						<td><%=flight.getFlightNumber()%></td>
						<td><%=flight.getPrice() %></td>
						<td><a href="flights/<%=flight.getfId()%>" class="cell-7">Book Flight</a></td>
					</tr>
				</form>
				<%
				}
				%>
			</tbody>
		</table>
		<br />
		<br />
		<p></p>

	</div>
</body>

</html>