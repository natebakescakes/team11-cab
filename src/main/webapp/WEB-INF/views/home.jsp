<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<title>Club Application for Booking</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/slick/slick.css" />

</head>
<body>

	<h1>Hello World</h1>
	<br>

	<div class="BookingID-Searchbox">
		<form:form action="${pageContext.request.contextPath}/bookingdetails"
			method="POST">
	
	Already have a booking?
	<br>
	Key in your Booking ID here:
	<br>
			<font color='red'>${ErrorMessage}</font>
			<br>
			<input name="booking_id" type="text">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>

		</form:form>
	</div>


	<div class="SearchBox">
		<form:form action="booking" method="POST">
			<h3>Make your booking here</h3>

			<label>Choose Facility Type</label>
			<div class="thing" id="wrapper">
				
					<c:forEach var="facilityType" items="${fTypeList}">
						<div>
							<label>
						  <input type="radio" name="ftype" value="${facilityType.typeId}" id="${facilityType.typeId}">				
							<img src="${pageContext.request.contextPath}/image/FacilityTypeIcons/${facilityType.typeId}.png" alt="slider-image">
							${facilityType.typeName}
							</label>
							
						</div>
					</c:forEach>
			

			</div>
		
			<br>
			
			<label>Date</label>
			<input name="date" type="date">

			<br>

			<label>Start Time</label>
			<input name="stime" id="starttime" type="time">
			<br>
			<label>End Time</label>
			<input name="endtime" id="endtime" type="time">
			<br>
			<input type="Submit" value="Search">
		</form:form>
	</div>


	

	<script type="text/javascript">
		$(document).ready(function() {
			$('.thing').slick({
				infinite : true,
				slidesToShow : 4,
				
			});
		});
		
	</script>
</body>
