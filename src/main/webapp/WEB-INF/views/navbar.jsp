<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="org.arpita.airlinereservationsystem.models.User"%>
  <%@ page import="org.springframework.security.core.userdetails.UserDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navbar</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 
</head>
<body>
        <nav>
            <ul>
	
				<%
				User user = (User)request.getAttribute("currentUser");
				if (user != null) {	
				%>
				 <li>Welcome <%= user.getFirstName() %> !</li> 
				<%
				} else {
				%>
				<li><a href="${pageContext.request.contextPath}/login"> Login</a></li>
				<%
				}
				%> 
			
								
              <%--   <li><a href="${pageContext.request.contextPath}/signUp"> SignUp</a></li> --%>
                <li><a href="${pageContext.request.contextPath}/allFlights" target="_blank"> All Available Flights </a></li>
                <li><a href="${pageContext.request.contextPath}/viewUserBooking" target="_blank"> View Booking</a></li> 
                <li><a href="${pageContext.request.contextPath}/logout"> Logout</a></li>
            </ul>
        </nav>

</body>
</html>