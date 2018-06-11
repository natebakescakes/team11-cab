<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Club Application for Booking</title>
</head>
<body>

Hello World
<br>

<div class="Searchbox">
	<form action ="bookingdetails" method ="POST">
	
	Already have a booking?
	<br>
	Key in your Booking ID here:
	<br>
 	<font color='red'>${ErrorMessage}</font>
	<br>
	<input name="booking_id">
	<button type="submit"><i class="fa fa-search"></i></button>
	
	</form>
</div>

</body>
</html>