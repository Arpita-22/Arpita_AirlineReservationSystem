<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Ticket"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket Page</title>
 <link rel="stylesheet" type="text/css" href="css/search.css">
 <link rel="stylesheet" type="text/css" href="/css/ticket.css">
 <style>
 .ticket, .passenger,.flight, h1,h3{
	color: grey;
}

 </style>
</head>
<body>
	<nav>
		<a href="${pageContext.request.contextPath}/">Home</a>
		<%-- <a href="${pageContext.request.contextPath}/passengerList">Passenger List</a> --%>
	</nav>
	<h1>Your Ticket</h1>

	<%Ticket ticket = (Ticket) request.getAttribute("ticket");%>
	<table class="ticket" border="1" borderColor="gray" height="80%" width="80%">
		<thead>
			<tr>
				<th>PNR Number</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th><%=ticket.getPnrNumber()%></th>
				<th><%=ticket.getPrice()%></th>
			</tr>
		</tbody>

	</table>
	<br />
	<br />

	<h3>Passenger Info</h3>
	<table class="passenger" border="1" borderColor="gray" height="80%" width="80%">
		<thead>
			<tr>
				<th>Passenger FirstName</th>
				<th>Passenger LastName</th>
				<th>Passenger Gender</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<th><%=ticket.getPassenger().getFirstName()%></th>
				<th><%=ticket.getPassenger().getLastName()%></th>
				<th><%=ticket.getPassenger().getGender()%></th>
			</tr>
		</tbody>

	</table>
	<br />
	<br />

	<h3>Flight Info</h3>
	<table class="flight" border="1" borderColor="gray" height="80%" width="80%">
		<thead>
			<tr>
				<th>Flight Number</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>

			</tr>
		</thead>
		<tbody>
			<tr>

				<th><%=ticket.getFlight().getFlightNumber()%></th>
				<th><%=ticket.getFlight().getSource()%></th>
				<th><%=ticket.getFlight().getDestination()%></th>
				<th><%=ticket.getFlight().getDepartureTime()%></th>
				<th><%= ticket.getFlight().getArrivalTime() %></th>

			</tr>
		</tbody>

	</table>

</body>
</html>