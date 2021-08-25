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
</head>
<body>
<h1> Your Booking is confirmed!</h1>

<%Booking booking = (Booking)request.getAttribute("booking"); %>

	<nav>
		<a href="${pageContext.request.contextPath}/">Home</a>
	</nav>
	<h2>Booking Details</h2>
		<% if(booking == null){
				out.print("No Booking on the list");
			}else{
				
			        out.print(booking); 
				%>
				
	<h3>Flight Info</h3>
				
	<table id="">
		<thead>
			<tr>
				<th>Flight Number</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Price</th>
				
			</tr>
		</thead>
		<tbody>
		<tr>
		<td><%= booking.getFlight().getFlightNumber() %></td>
		<td><%= booking.getFlight().getSource() %></td>
		<td><%= booking.getFlight().getDestination() %></td>
		<td><%= booking.getFlight().getPrice() %></td>
		</tr>
		</tbody>
		
		</table>
		
		<h3>Passenger Info</h3>
		
		<table id="">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				
			</tr>
		</thead>
		<tbody>
		<%
		for(Passenger passenger: booking.getPassengers()){
			%>
		<tr>
		
		<td><%= passenger.getFirstName() %></td>
		<td><%= passenger.getLastName() %></td>
		<td><%= passenger.getGender() %></td>
		</tr>
		
		<% }%>
		</tbody>
		
		</table>
				
				<%
					}	
				%>
	
				 
			
				<a href="${pageContext.request.contextPath}/ticket/<%= booking.getbId() %>">Generate Ticket</a>
				
</body>
</html>