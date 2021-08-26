<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.arpita.airlinereservationsystem.models.Passenger"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passenger List</title>
<!-- <link rel="stylesheet" type="text/css" href="css/passengerList.css"> -->
<link rel="stylesheet" type="text/css" href="css/search.css">
<Style>
body {
	background: linear-gradient(to right, #696969 0%, #C0C0C0 100%);
}
body {
  font-family: sans-serif;
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


table{
 margin-left: auto;
  margin-right: auto;
}
</Style>
</head>
<body>
	 <%@include file="home_link.html"  %> 
	 
	<h1 style="text-align:center;">Passenger List</h1>
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
				<%-- <td><a href="${pageContext.request.contextPath}/ticket/<%=passenger.getpId()%>">Generate
						Ticket</a></td> --%>
			</tr>
				<%
					}	
				}
				%>
				<%-- <a href="${pageContext.request.contextPath}/ticket/">Generate Ticket</a> --%>
				 <a href="${pageContext.request.contextPath}/booking">Confirm Booking</a> 
				
		</tbody>
	</table>
</body>
</html>