<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.arpita.airlinereservationsystem.models.Passenger"%>
<%@ page
	import="org.arpita.airlinereservationsystem.models.PassengerList"%>
	<%@ page import="java.util.List" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Passenger List</h1>
<%-- <% List <Passenger> PassengerList = (List)request.getAttribute("passengerList"); %> --%>
		<table id="hiddenfield">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Date Of Birth</th>
					<th>Gender</th>
					<th>Personal Id</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<% List<Passenger> passengers = (List)request.getAttribute("passengers"); 
				for (Passenger passenger : passengers) {
				%>
				<!-- <form method="post" action="createBooking" class="inline"
					method="post"> -->

					<tr>
						<td><%=passenger.getFirstName()%></td>
						<td><%=passenger.getLastName()%></td>
						<td><%=passenger.getEmail()%></td>
						<td><%=passenger.getDateOfBirth()%></td>
						<td><%=passenger.getGender()%></td>
						<td><%=passenger.getPersonalId()%></td>
						<td><a href="passenger/<%=passenger.getpId()%>">Update Passenger</a></td>
						<%--  <form method="post" action="passengers/<%=passenger.getpId()%>" class="inline"> --%>
						<td><a href="passengers/<%=passenger.getpId()%>">Remove Passenger</a></td>
						<!-- </form> -->
					</tr>
				
				<%
				}
				%>
			</tbody>
		</table>
</body>
</html>