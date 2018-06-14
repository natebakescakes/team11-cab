<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Details</title>

</head>
<body>
<!--  put in the include confirm booking logo here -->

<c:if test="${param.bookingid}">

<img src="${pageContext.request.contextPath}/image/bookingcomplete.PNG" />
</c:if>

<h2>Booking Details</h2>
<br>
<p>Check your booking details here</p>
<br>
<div class ="container-fluid">
<div class="panel panel-default" id="panel" style="padding-left: 20px; width:80%" >

<h3> Booking ID:${booking.bookingId}</h3>

	<div class="row">
	<div class="col-sm-5"></div>
	<div class="col-sm-7">
	<fmt:parseDate value="${booking.transDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedtransDateTime" type="both" />
	Booking Date : <fmt:formatDate pattern = "d MMM yyyy"  value = "${parsedtransDateTime}" />
	<br>
	<br>
	
	</div>
	
	</div>
	
	<div class="row" >
		<div class="col-sm-5">
		Name :  ${booking.member.firstName} ${booking.member.lastName}
		
		</div>
		<div class="col-sm-7">
		Member ID : ${booking.member.userid}
		
		</div>
	</div>

<br>
Facility Name : ${booking.facility.facilityName }
<br>
<br>
<!-- convert LocalDateTime to date-time -->
<fmt:parseDate value="${booking.startDateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedStartDateTime" type="both" />
<fmt:parseDate value="${booking.endDateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedEndDateTime" type="both" />
<div class="row" >
		<div class="col-sm-5">
		Start Date : <fmt:formatDate pattern = "d MMM yyyy"  value = "${parsedStartDateTime}" />
		<br>
		<br>
		</div>
		<div class="col-sm-7">
		End Date : <fmt:formatDate pattern = "d MMM yyyy"  value = "${parsedEndDateTime}" />
		<br>
	    <br>
		</div>
	</div>


<div class="row" >
		<div class="col-sm-5">
		Start Time : <fmt:formatDate pattern = "hh:mm a"  value = "${parsedStartDateTime}" />
		<br>
		
		</div>
		<div class="col-sm-7">
		End Time : <fmt:formatDate pattern = "hh:mm a" value="${parsedEndDateTime}" />
		<br><br><br><br>
		
		</div>
	</div>

<div class="row">
<div class="col-sm-8"></div>
<div class="col-sm-4">
<a href="${pageContext.request.contextPath}/home" class="btn btn-default">Back To Home</a>
</div>


</div>

<br><br><br><br>
<label>For more information please contact system administrator at sysadmin@cab.com.sg</label>


</div>
</div>

</body>
</html>