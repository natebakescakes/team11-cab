<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Make Booking</h3>

<c:if test="${bookingSuccess}">
	<div class="alert alert-success">
		Booking Successful!
	</div>
</c:if>

<div class="form-group">
<form:form action="" method="POST">

	<label>Choose Facility Type</label>
	<select name="typeId" class="form-control">
		<option value="-1" selected disabled hidden>- Select a Facility Type -</option>
		<c:forEach var="facilityType" items="${ftypes}">
			<option value="${facilityType.typeId}"
				${facilityType.typeId == typeId ? 'selected="selected"' : ''}>
				${facilityType.typeName}</option>
		</c:forEach>
	</select>
	
	<input type="submit" name="refresh" value="Refresh">
	<input type="submit" name="submit" value="Submit">
	
	<br>
	<label>Date</label>
<%-- 	<input name="date" type="date" value="${date}" class="form-control"> --%>
	
    <input id="datepicker" name="date" type="text" class="form-control" value="${date}">

	<br>
	
	<label>Choose Room</label>
	<select name="room" class="form-control">
		<c:forEach var="room" items="${rooms}">
			<option value="${room.facilityId}">${room.facilityName}</option>
		</c:forEach>
	</select>
	
	<label>Start Time</label>
	<input name="stime" id="starttime"  step=3600 value="${stime}">

	<label>End Time</label>
	<input name="endtime" id="endtime" step=3600 value="${endtime}">

</form:form>
</div>

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

<script>
	$('#datepicker').datepicker({
		format : "dd/mm/yyyy"
	});
</script>
