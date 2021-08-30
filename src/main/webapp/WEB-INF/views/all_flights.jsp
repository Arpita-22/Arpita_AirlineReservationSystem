<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Flight"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Flights</title>
<link rel="stylesheet" type="text/css" href="css/search.css">
</head>
<style>
body {
	/*   background: linear-gradient(to right, #696969 0%, #C0C0C0 100%); */
	background-image: url("images/woodenMap.jpg");
}

table {
	margin-left: auto;
	margin-right: auto;
}

a {
	color: black;
}

.table-container {
	height: 40em;
}

table {
	display: flex;
	flex-flow: column;
	height: 100%;
	width: 80%;
}

table thead {
	/* head takes the height it requires, 
    and it's not scaled when table is resized */
	flex: 0 0 auto;
	width: calc(100% - 0.9em);
}

table tbody {
	/* body takes all the remaining available space */
	flex: 1 1 auto;
	display: block;
	overflow-y: scroll;
}

table tbody tr {
	width: 100%;
}

table thead, table tbody tr {
	display: table;
	table-layout: fixed;
}
</style>
<body>
	<nav>
		<a href="${pageContext.request.contextPath}/">Home</a>
	</nav>
	<h1 style="text-align: center;">All Available Flights</h1>
	<div class="table-container">
		<table id="hiddenfield">
			<thead>
				<tr>
					<th>Source</th>
					<th>Destination</th>
					<th>Departure Date</th>
					<th>Departure Time</th>
					<th>Arrival Date</th>
					<th>Arrival Time</th>
				</tr>
			</thead>
			<tbody>
				<%
			List<Flight> flights = (List) request.getAttribute("flights");
			%>
				<%
			for (Flight flight : flights) {
			%>
				<tr>
					<td><%=flight.getSource()%></td>
					<td><%=flight.getDestination()%></td>
					<td><%=flight.getDepartureDate()%></td>
					<td><%=flight.getDepartureTime()%></td>
					<td><%=flight.getArrivalDate()%></td>
					<td><%=flight.getArrivalTime()%></td>
				</tr>
				<%}%>
			</tbody>
		</table>
	</div>
</body>
</html>