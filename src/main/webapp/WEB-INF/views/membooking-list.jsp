<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Insert title here</title>
</head>
<body>
	<h3>My Bookings</h3>


	<div class="row">
		<table id="mbTable" style="width: 100%"
			class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Booking ID</th>
					<th>Facility Name</th>
					<th>Start Date</th>
					<th>Start Time</th>
					<th>End Date</th>
					<th>End Time</th>
					<th>Status</th>
					<th>Cancel</th>
				</tr>

			</thead>
		</table>
	</div>

	<a href="${pageContext.request.contextPath}/home"
		class="btn btn-primary">Back</a>

</body>
</html>



