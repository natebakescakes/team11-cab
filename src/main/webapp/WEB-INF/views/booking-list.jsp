<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Insert title here</title>
</head>
	<body>
		<h3>Bookings Page </h3>
	
	<a href="${pageContext.request.contextPath}/booking" class="btn btn-primary">Add New Booking</a>
	<a href="${pageContext.request.contextPath}/booking" class="btn btn-primary">Maintenance Booking</a>
	<div class="container">
		<div class="row" style="max-width:100%">
			<div class="centered" style="align:center; width:80%"  >
			<div id="MyEdit"></div>
				<table id="bTable" style="width:100%" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Booking ID</th>
							<th>Facility Name</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Start Time</th> 
							<th>End Time</th>
							<th>Edit</th> 
							<th>Delete</th> 
						</tr>

					</thead>
				</table>

			</div>

		</div>
	</div>


</body>
</html>

	
	
	