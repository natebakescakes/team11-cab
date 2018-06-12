<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<h3>Bookings </h3>
	
	<%--<a href="${pageContext.request.contextPath}/booking/create">Add New Booking</a>
	 <td><input type="submit" value="Add New Booking" class="btn btn-primary"/></td>--%>
	<input type=submit onClick="${pageContext.request.contextPath}/booking/create" value="Add New Booking"/>
	<a href="${pageContext.request.contextPath}/booking/edit">Maintenance Booking</a>
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr>
				<th><spring:message code="fieldLabel.BookingId" /></th>
				<th><spring:message code="fieldLabel.facilityName" /></th>
				<th><spring:message code="fieldLabel.startDate" /></th>
				<th><spring:message code="fieldLabel.endDate" /></th>
				<th><spring:message code="fieldLabel.startTime" /></th>
				<th><spring:message code="fieldLabel.endTime" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="booking" items="${bookingList}">
				<tr>
					<td>${booking.bookingId}</td>
					<td>${booking.facility.facilityName}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${booking.startDate}"/></td>
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${booking.endDate}"/></td>
					<td><fmt:formatDate type="time" value="${booking.startDate}" /></td>
					<td><fmt:formatDate type="time" value="${booking.endDate}" /></td>
			 		<td align="center">
					<a href="${pageContext.request.contextPath}/booking/edit/${booking.bookingId}.html"><spring:message
								code="caption.edit" /></a>
					</td>
					<td>
					<a href="${pageContext.request.contextPath}/booking/delete/${booking.bookingId}.html"><spring:message
								code="caption.delete" /></a>
					</td>		
				</tr>
			</c:forEach>
		</tbody>
	</table>

	
	
	