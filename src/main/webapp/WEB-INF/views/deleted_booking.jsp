<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deleted  Booking</title>
</head>
<style>
body{
   background-image: url("${pageContext.request.contextPath}/images/sadCartoon.jpg");
     background-size: 1500px 1000px;
	background-repeat: no-repeat;  
  /*  background: linear-gradient(to right, #abb9be 0%, #C0C0C0 100%); */
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



</style>
<body>
<%@include file="home_link.html"  %> 
<h1> Your Booking has been deleted !</h1>

</body>
</html>