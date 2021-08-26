<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Booking"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Passenger"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Booking Page</title>
<link rel="stylesheet" type="text/css" href="css/search.css">
</head>
<style>
body {
	background: linear-gradient(to right, #696969 0%, #C0C0C0 100%);
}

table {
	margin-left: auto;
	margin-right: auto;
}
a{
    color: brown; 
    text-decoration: none;
    /* background-color: red;  */  
}
</style>
<body>
	<h1 style="text-align: center">Your Booking is confirmed!</h1>

	<%
	Booking booking = (Booking) request.getAttribute("booking");
	%>	
	<h3 style="text-align: center">
		Your Booking Id is
		<%=booking.getbId()%></h3>

	<%@include file="home_link.html"%> <a
		href="${pageContext.request.contextPath}/ticket/<%= booking.getbId() %>">Generate
		Ticket |</a>
	<a
		href="${pageContext.request.contextPath}/removeBooking/<%= booking.getbId() %>">Delete
		Booking</a>

	<h2 style="text-align: center">Booking Details</h2>
	<%
	if (booking == null) {
		out.print("No Booking on the list");
	} else {
	%>

	<h3 style="text-align: center">Flight Info</h3>
	<table id="">
		<thead>
			<tr>
				<th>Flight Number</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Departure Date</th>
				<th>Departure Time</th>
				<th>Arrival Date</th>
				<th>Arrival Time</th>
				<th>Price</th>


			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=booking.getFlight().getFlightNumber()%></td>
				<td><%=booking.getFlight().getSource()%></td>
				<td><%=booking.getFlight().getDestination()%></td>
				<td><%=booking.getFlight().getDepartureDate()%></td>
				<td><%=booking.getFlight().getDepartureTime()%></td>
				<td><%=booking.getFlight().getArrivalDate()%></td>
				<td><%=booking.getFlight().getArrivalTime()%></td>
				<td><%=booking.getFlight().getPrice()%></td>
			</tr>
		</tbody>

	</table>

	<h3 style="text-align: center">Passenger Info</h3>

	<table id="">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Date Of Birth</th>

			</tr>
		</thead>
		<tbody>
			<%
			for (Passenger passenger : booking.getPassengers()) {
			%>
			<tr>

				<td><%=passenger.getFirstName()%></td>
				<td><%=passenger.getLastName()%></td>
				<td><%=passenger.getGender()%></td>
				<td><%=passenger.getDateOfBirth()%></td>
			</tr>

			<%
			}
			%>
		</tbody>

	</table>

	<%
	}
	%>



	

</body>
</html>