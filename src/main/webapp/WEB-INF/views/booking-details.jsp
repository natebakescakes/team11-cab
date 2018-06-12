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
<c:if test="${pageContext.request.contextPath}='from bookings'">

<img src="${pageContext.request.contextPath}/image/bookingcomplete.PNG" />
</c:if>
<br>
Is this the booking ID that you sent me?
<br>
Booking ID:${booking.bookingId}
<br>
Booking Date: ${booking.transDate}
<br>
Name:  ${booking.member.firstName} ${booking.member.lastName}
<br>
Member ID: ${booking.member.userid}
<br>
Facility Name: ${booking.facility.facilityName }
<br>
Start Date: <fmt:formatDate pattern = "dd-MMM-yyyy"  value = "${booking.startDate}" />
<br>
End Date: <fmt:formatDate pattern = "dd-MMM-yyyy"  value = "${booking.endDate}" />
<br>

Start Time: <fmt:formatDate pattern="hh:mm a" value="${booking.startDate}" />
<br>
End Time: <fmt:formatDate pattern = "hh:mm a" value="${booking.endDate}" />




</body>
</html>