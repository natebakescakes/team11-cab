<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<title>Club Application for Booking</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/slick/slick-theme.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/slick/slick.css" />

</head>
<body>

	<h1>Hello World</h1>
	<br>
	<div class="container">

	<div class="col-sm-7">
	<div class="panel panel-default" id="SearchBox">
	<div class="panel panel-body">
		<h3>Make your booking here</h3>
			
		<form:form action="booking" method="POST">
		<label>Choose Facility Type</label>
		<div class="row">
		<br>
		<br>
		</div>
		<div class="row">
			<div class="col-sm-1">
			<br>
		<a class="prev"><i class="fa fa-chevron-circle-left" style="font-size:24px"></i></a>
		</div>
		<div class="col-sm-10">
				<div class="thing" id="wrapper">
			<c:forEach var="facilityType" items="${fTypeList}">
					<div align="center">
						<label>
							<img
							src="${pageContext.request.contextPath}/image/FacilityTypeIcons/${facilityType.typeId}.png"
							alt="slider-image"> ${facilityType.typeName}
							<br>
							<input type="radio" name="ftype"
							value="${facilityType.typeId}" id="${facilityType.typeId}">
						</label>

					</div>
				</c:forEach>

			</div>
		</div>
		<div class="col-sm-1">
		<br>
		<a class="next"><i class="fa fa-chevron-circle-right" style="font-size:24px"></i></a>
		</div>
	
		<br>
		</div>
		<div class="row">
				<div class="col-sm-2">
					<label>Date: </label>
				</div>
				<div class="col-sm-10">
				<input name="date" type="date">
				</div>
			
			<br>
		</div>
		<div class="row">
				<div class="col-sm-2">
						<label>Start Time: </label>
				</div>
				<div class="col-sm-10">
				<input name="stime" id="starttime" type="time">
				</div>
			
			<br>
		</div>
		
	<div class="row">
				<div class="col-sm-2">
						<label>End Time: </label>
				</div>
				<div class="col-sm-10">
				<input name="endtime" id="endtime" type="time">
				</div>
			
			<br>
		</div>
			
		
			
			<input type="Submit" class="btn btn-default" value="Search">
			
		</form:form>
		
			</div>
		</div>
		</div>
		
			<div class="col-sm-5">
	<div class="panel panel-default" id="BookingID-Searchbox" style="width:100%">
		<div class="panel panel-body" align="left">
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

	</div>
</div>
		
</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.thing').slick({
				infinite : true,
				slidesToShow : 3,
				prevArrow: $('.prev'),
			    nextArrow: $('.next'),
				
			});
		});
		
	
	</script>
</body>
