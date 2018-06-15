<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<head>
<title>Club Application for Booking</title>


</head>
<body>
	<div style="max-width: 300px; margin: auto">
		<c:if test="${param.loginSuccess ne null}">
			<div class="row">
				<div class="alert alert-success" role="alert">Login
					Successful!</div>
			</div>
		</c:if>
	</div>

	<h1>Welcome to Sembawang Club</h1>
	<br>

	<div class="col-sm-7">
		<div class="panel panel-default" id="SearchBox">
			<div class="panel panel-heading">
			<h4>Make your booking here:</h4>
			</div>
			<div class="panel panel-body">
				

				
				<form:form action="${pageContext.request.contextPath}/booking" class="form-group" method="POST">
					<label>Choose Facility Type</label>
					<div class="row">
						<br>
						<br>

					</div>
					<div class="row">
						<div class="col-sm-1">
							<br> <a class="prev"><i
								class="fa fa-chevron-circle-left" style="font-size: 24px"></i></a>
						</div>
						<div class="col-sm-10">
							<div class="thing" id="wrapper">
								<c:forEach var="facilityType" items="${fTypeList}">
									<div align="center">
										<label> <img
											src="${pageContext.request.contextPath}/image/FacilityTypeIcons/${facilityType.typeId}.png"
											alt="slider-image"> ${facilityType.typeName} <br>
											<input type="radio" name="typeId"
											value="${facilityType.typeId}" id="typeId">
										</label>

									</div>
								</c:forEach>

							</div>
						</div>
						<div class="col-sm-1">
							<br> <a class="next"><i
								class="fa fa-chevron-circle-right" style="font-size: 24px"></i></a>
						</div>

						<br>
					</div>
					<sec:authorize access="hasRole('ADMIN')">
					<div class="row">
						<div class="col-sm-6">

							<label><input class="form-control" type="checkbox" name="isMaintenance">For
							Maintenance</label>
							<br><br>
						</div>
						<div class="col-sm-6"></div>
					</div>
					</sec:authorize>
					
					<div class="row">
						<div class="col-sm-2">
							<label>Date: </label>
						</div>
						<div class="col-sm-10">

							<input name="date" class="form-control" type="date" style="text-align:center">
							

						</div>

						<br>
					</div>
					

					<div class="row">

						<br>
						<div class="col-sm-2">

							<label>Start Time: </label>
						</div>
						<div class="col-sm-10">

							<input class="form-control timepicker" name="stime" id="starttime"
							autocomplete="off">
						
						</div>

						<br><br>
					</div>

					<div class="row">
						<div class="col-sm-2">
							<label>End Time: </label>
						</div>
						<div class="col-sm-10">

						<input class="form-control timepicker" name="endtime" id="endtime"autocomplete="off">

						</div>

						<br>
					</div>



					<input type="Submit" class="btn btn-default" name="refresh"
						value="Submit"> <font color='red'>${TimeErrorMessage}</font>
	
				</form:form>

			</div>
		</div>
	</div>

	<div class="col-sm-5">
		<div class="panel panel-default" id="BookingID-Searchbox"
			style="width: 70%">
			<div class="panel panel-body" align="left">
			Already have a booking?
					<br>
					Key in your Booking ID here:
					<br>
					<div class="form-group">
							<form:form class="form-inline"
					action="${pageContext.request.contextPath}/bookingdetails"
					method="POST">
	
					<font color='red'>${ErrorMessage}</font>
					<br>
					<input class="form-control" name="booking_id" type="text">
					<button class="btn btn-default" type="submit">
						<i class="fa fa-search " style="font-size:20px;" ></i>
					</button>
				
				</form:form>
					</div>
			
			</div>

		</div>
	</div>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/home.js"></script>

</body>
