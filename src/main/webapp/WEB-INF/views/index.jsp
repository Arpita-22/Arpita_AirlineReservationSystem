<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Airline Reservation System</title>
</head>
<style>
    body{
        background-color: rgb(198, 218, 176);
    }
    
    input[type=submit]{
    background-color: red;
    color: white;
        
	}
</style>

<body>
    <div class="main-container">
        <h2 id="main-container-item">Fly with us</h2>
        <nav>
            <ul>
				<%
				if (session.getAttribute("currentUser") != null) {
				%>
				<li>Welcome ${currentUser.getFirstName()}</li>
				<%
				} else {
				%>
				<li><a href="${pageContext.request.contextPath}/login"> Login</a></li>
				<%
				}
				%>
				<%-- <li><a href="${pageContext.request.contextPath}/login"> Login</a></li> --%>
                <li><a href="${pageContext.request.contextPath}/signUp"> SignUp</a></li>
                <li><a href="#" target="_blank"> Flight </a></li>
                <li><a href="#" target="_blank"> Travel Info</a></li> 
                <li><a href="#" target="_blank"> Add to Cart</a></li>
                <li><a href="${pageContext.request.contextPath}/logout"> Logout</a></li>
            </ul>
        </nav>

        <div class="container-body">
            <form action="${pageContext.request.contextPath}/search" method="post">
                <img src="images/AirPlane.jpg">
                <h3>Search Flights</h3>
                <!-- For Future Use -->
                <label for="state" style="color:blue;">Leaving From</label>
                <select name="stateFrom" id="state" >
                    <option  value="seattle">Seattle</option>
                        <option value="Denver">Denver</option>
                            <option value="Boston">Boston</option>
                            <option value="California">California</option>
                </select>

                <label for="state" style="color:blue;">Going To</label>
                <select name="stateTo" id="state" >
                    <option  value="seattle">Seattle</option>
                            <option value="Denver">Denver</option>
                            <option value="California">California</option>
                            <option value="boston">Boston</option>
                </select>   

                <label for="depart" style="color:blue;">Departing</label>
                <input type="date"  name="depart" min="2021-08-26" max="2021-08-26"/> 

                <label for="returning" style="color:blue;">Returning</label>
                <input type="date"  name="returning" min="2021-08-26" max="2021-08-26"/> 

                <input type="submit" name="submit" value="search" onSubmit="${pageContext.request.contextPath}/search"/>
            </form>
        </div><br /><br />


        <footer>
            @Copyright Reserved
        </footer>
    </div>

</body>

</html>