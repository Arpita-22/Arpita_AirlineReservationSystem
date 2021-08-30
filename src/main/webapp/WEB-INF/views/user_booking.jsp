<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Booking"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Passenger"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Booking</title>
<link rel="stylesheet" type="text/css" href="css/search.css">
</head>
<style>
body {

	background-image: url("images/globe.jpg");
	background-size: 1500px 1000px;
	background-repeat: no-repeat;
	
	
}

table {
	margin-left: auto;
	margin-right: auto;
}

table thead th{
 background: linear-gradient(to right, #704214 0%, #703642 100%);

}

.button{
 color: brown;
}

  h3, h4{
 color: #3d0c02;
}



</style>
<body>
	<%@include file="home_link.html"%>
	<h3 style="text-align: center;">
		User Booking
		</h3>
		<%
		List<Booking> bookings = (List) request.getAttribute("bookings");
		int count = 1;

		for (Booking booking : bookings) {
		%>
		<table>
			<h4 style="text-align: center; color: beige;">
				Booking Details #
				<%=count%>
				</h4>
				<%
				if (booking == null) {
					out.print("No Booking on the list");
				} else {
				%>

				<h4 style="text-align: center;">
					Flight Info
					</h3>

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
								<td><%=booking.getFlight().getDepartureDate() %></td>
								<td><%=booking.getFlight().getDepartureTime() %></td>
								<td><%=booking.getFlight().getArrivalDate() %></td>
								<td><%=booking.getFlight().getArrivalTime() %></td>
								<td><%=booking.getFlight().getPrice()%></td>
							</tr>
						</tbody>

					</table>

					<h4 style="text-align: center;">
						Passengers
						</h4>

						<table id="">
							<thead>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Gender</th>
									<th> Date Of Birth</th>
									

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
									<td><%=passenger.getDateOfBirth() %></td>
								</tr>

								<%
								}
								%>
							</tbody>

						</table>

						<%
						}
						%>
					
		</table>

		<%
		out.println(
				"=========================================================================================================================================================================================");
		count++;
		}
		%>
	
</body>
</html>