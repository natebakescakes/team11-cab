<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar {
	overflow: hidden;
	background-color: #333;
	font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.navbar-right{
float: right
}

.navbar a:hover {
	background-color: red;
}

.show {
	display: block;
}
</style>
</head>
<body>


<div class="navbar">

		<a href="#home">Home</a>
		<a href="#home">Facilities</a>
		<a href="#news">My Bookings</a>
		<div class="navbar-right"> 
		<a href="homepage.jsp">Login/Sign Up</a>
		</div>
	</div>

	
</body>
</html>