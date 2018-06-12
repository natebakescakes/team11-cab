<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Make Booking</h3>

<form:form action="" method="POST">
	<label>Choose Facility Type</label>
	<select name="ftype">
		<c:forEach var="facilityType" items="${ftypes}">
			<option value="${facilityType.typeId}"
					${facilityType.typeId == typeId ? 'selected="selected"' : ''}">
				${facilityType.typeName}
			</option>
		</c:forEach>
	</select>
	
	<label>Date</label>
	<input name="date" type="datetime-local">

	<br>
	
	<label>Choose Room</label>
	<select name="room">
		<c:forEach var="room" items="${rooms}">
			<option value="${room.facilityId}">${room.facilityName}</option>
		</c:forEach>
	</select>
	
	<label>Start Time</label>
	<input name="stime" id="starttime" type="datetime-local">

	<label>End Time</label>
	<input name="endtime" id="endtime" type="datetime-local">

	<br> <input type="submit" value="Book Now"> <br>

	<!-- Generate tables for each room -->
	<c:forEach var="room" items="${rooms}">
		<label>${room.facilityName}</label>
		<table>
			<tr>
				<td>9AM</td>
				<td>10AM</td>
				<td>11AM</td>
				<td>12PM</td>
				<td>1PM</td>
				<td>2PM</td>
			</tr>
			<tr>
				<td>3PM</td>
				<td>4PM</td>
				<td>5PM</td>
				<td>6PM</td>
				<td>7PM</td>
				<td>8PM</td>
			</tr>
		</table>
	</c:forEach>
</form:form>
