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
 <link rel="stylesheet" type="text/css" href="css/home_link.css">
<Style>
body{
	
	background-image: url("${pageContext.request.contextPath}/images/woodenMap.jpg");
	background-size: 1500px 1000px;
	background-repeat: no-repeat;
}

table{
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  min-width: 400px;
  text-align: center;
   vertical-align: middle;
  
}

thead tr{
	background-color:#ffe6e6; 
	 text-align: left; 
	font-weight: bold;
	background: linear-gradient(to right, #704214 0%, #703642 100%);
} 

table tbody tr{
	border-bottom: 1px solid grey;
	
}

table{
  margin-right: auto;
  margin-left:auto;
}

table th, table td{
	
	padding: 12px 15px;
	
}

tbody tr{
	background-color: white;
}

table thead th{
	color: white;
}
 

.button {
  font: bold 11px Arial;
  text-decoration: none;
  background-color: #EEEEEE;
  color: black;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;
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
		
			</tr>
				<%
					}	
				}
				%>
				 <a  class="button" href="${pageContext.request.contextPath}/booking">Confirm Booking</a> 
				
		</tbody>
	</table>
</body>
</html>