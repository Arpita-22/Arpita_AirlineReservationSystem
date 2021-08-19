<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Passenger"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passenger List</title>
<link rel="stylesheet" type="text/css" href="css/passengerList.css">
<Style>
body {
	background-color: lightyellow;
}

table {
	border-collapse: collapse;
	margin: 25px 0;
	font-size: 0.9em;
	min-width: 400px;
	text-align: center;
	vertical-align: middle;
}

thead tr {
	color: darkbrown;
	font-weight: bold;
	background: linear-gradient(to bottom, #33ccff 0%, #ff99cc 100%);
}

table tbody tr {
	border-bottom: 1px solid grey;
}

table th, table td {
	padding: 12px 15px;
}

tbody tr {
	background-color: white;
}

h1 {
	color: #654321;
}
</Style>
</head>
<body>
	<nav>
		<a href="${pageContext.request.contextPath}/">Home</a>
	</nav>
	<h1>Passenger List</h1>
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
				<th></th>
			</tr>
		</thead>
		<tbody>
			<% if(request.getAttribute("passengers") == null){
				out.print("No Passengers on the list");
			}else{
				
			List<Passenger> passengers = (List)request.getAttribute("passengers"); 
				for (Passenger passenger : passengers) {
				%>

			<tr>
				<td><%=passenger.getFirstName()%></td>
				<td><%=passenger.getLastName()%></td>
				<td><%=passenger.getEmail()%></td>
				<td><%=passenger.getDateOfBirth()%></td>
				<td><%=passenger.getGender()%></td>
				<td><%=passenger.getPersonalId()%></td>
				<td><a href="${pageContext.request.contextPath}/passenger/<%=passenger.getpId()%>">Update
						Passenger</a></td>
				<td><a href="${pageContext.request.contextPath}/passenger/remove/<%=passenger.getpId()%>">Remove
						Passenger</a></td>
				<td><a href="${pageContext.request.contextPath}/ticket/<%=passenger.getpId()%>">Generate
						Ticket</a></td>
			</tr>
				<%
					}	
				}
				%>
				<%-- <a href="${pageContext.request.contextPath}/ticket/">Generate Ticket</a> --%>
		</tbody>
	</table>
</body>
</html>