<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Details</title>
</head>
<body>
<!--  put in the include confirmbooking logo here -->

Is this the booking ID that you sent me?

Booking ID: ${booking.bookingId}
<br>
Booking Date: ${booking.transDate}
<br>
Name:  ${booking.member.firstName} ${booking.member.lastName}
<br>
Member ID: ${booking.member.userid}
<br>
Start Date: ${booking.startDate}
<br>
End Date: ${booking.endDate}
<br>
Start Time: ${start_time}
<br>
End Time: ${end_time}




</body>
</html>