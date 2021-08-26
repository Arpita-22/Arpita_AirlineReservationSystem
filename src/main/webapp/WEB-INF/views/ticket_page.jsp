<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Ticket"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Passenger"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket Page</title>
<link rel="stylesheet" type="text/css" href="css/search.css">
<!-- <link rel="stylesheet" type="text/css" href="/css/ticket.css"> -->
</head>
<style>
body {
  font-family: sans-serif;
  background: linear-gradient(to right, #696969 0%, #C0C0C0 100%);
}

table {
  border-collapse: collapse;
  border: 1px solid black;
  text-align: center;
    vertical-align: middle;
 margin-left: auto;
  margin-right: auto;
}

th, td {
  border: 1px solid black;
   padding: 8px;
}


/* thead th {
  width: 25%;
} */

.cell-7 {
  background-color: gold;
  font-weight: bold;
}

caption{
  font-weight: bold;
  font-size: 24px;
  text-align: left;
  color: #333;
  margin-bottom: 16px;
}

thead {
   background-color: gray;
   color: white;
    font-size: 0.875rem;
    text-transform: uppercase;
    letter-spacing: 2%;
}	


tbody tr:nth-child(odd) {
  background-color: #fff;
}

tbody tr:nth-child(even) {
  background-color: #eee;
}

tbody th {
  background-color: #36c;
  color: #fff;
  text-align: left;
}

tbody tr:nth-child(even) th {
  background-color: #25c;
  
}

tbody tr:nth-child(odd) th {
  background-color: #25c;
}

#hiddenfield > tbody > tr > td:nth-child(6){
	 background-color: #eee;
	
}
</style>
<body>
	 <%@include file="home_link.html"  %> 
	 
	<h1 style="text-align:center;">Your Ticket</h1>
	<%Ticket ticket = (Ticket) request.getAttribute("ticket");%>
	<table>


		<thead>
			<tr>
				<th>PNR Number</th>
				<th>Total Price</th>
			</tr>
		</thead>



		<tbody>
			<tr>
				<td><%=ticket.getPnrNumber()%></td>
				<td><%=ticket.getPrice()%></td>
			</tr>
		</tbody>
	</table>

	<h3 style="text-align:center;">Flight Information</h3>
	<table>


		<thead>
			<tr>
				<th>Origin</th>
				<th>Destination</th>
				<th>Departure Date</th>
				<th>Departure Time</th>
				<th>Arrival Date</th>
				<th>Arrival Time</th>
				<th>Flight Number</th>
			</tr>
		</thead>



		<tbody>
			<tr>
				<td><%=ticket.getBooking().getFlight().getSource()%></td>
				<td><%=ticket.getBooking().getFlight().getDestination()%></td>
				<td><%=ticket.getBooking().getFlight().getDepartureDate()%></td>
				<td><%=ticket.getBooking().getFlight().getDepartureTime()%></td>
				<td><%=ticket.getBooking().getFlight().getArrivalDate()%></td>
				<td><%=ticket.getBooking().getFlight().getArrivalTime()%></td>
				<td><%=ticket.getBooking().getFlight().getFlightNumber()%></td>
			</tr>
		</tbody>
	</table>
	<h3 style="text-align:center;">Passenger Information</h3>

	<table>

		<%
		List<Passenger> passengers = ticket.getBooking().getPassengers();
		for (Passenger passenger : passengers) {
		%>

		<thead>
			<tr>
				<th>First Name</th>
				<th>Last name</th>
				<th>Gender</th>
				<th>Date Of Birth</th>
			</tr>
		</thead>



		<tbody>
			<tr>
				<td><%=passenger.getFirstName()%></td>
				<td><%=passenger.getLastName()%></td>
				<td><%=passenger.getGender()%></td>
				<td><%=passenger.getDateOfBirth() %></td>
			</tr>
		</tbody>
		<%  }%>
	</table>


</body>
</html>