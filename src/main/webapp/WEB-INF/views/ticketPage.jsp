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

</head>
<body>
	<nav>
		<a href="${pageContext.request.contextPath}/">Home</a>
		<%-- <a href="${pageContext.request.contextPath}/passengerList">Passenger List</a> --%>
	</nav>
	<h1>Your Ticket</h1>

	<%Ticket ticket = (Ticket) request.getAttribute("ticket");%>
	<%= ticket %>

</body>
</html>