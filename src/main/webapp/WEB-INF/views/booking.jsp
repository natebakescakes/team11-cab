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
	
	<label>Choose Facility</label>
	<select id="choose-room" name="room" class="form-control">
		<c:forEach var="room" items="${rooms}">
			<option value="${room.facilityId}">${room.facilityName}</option>
		</c:forEach>
	</select>
	
	<label>Start Time</label>
	<input name="stime" id="starttime" type="time" step=3600 value="${stime}">

	<label>End Time</label>
	<input name="endtime" id="endtime" type="time" step=3600 value="${endtime}">

</form:form>
</div>

<!-- Generate tables for each room -->
<c:forEach var="room" items="${rooms}">
	<h4>${room.facilityName}</h4>
	<div class="container booking-grid">
		<div class="row" data-value="${room.facilityId}">
			<div class="col-sm-2">9AM</div>
			<div class="col-sm-2">10AM</div>
			<div class="col-sm-2">11AM</div>
			<div class="col-sm-2">12PM</div>
			<div class="col-sm-2">1PM</div>
			<div class="col-sm-2">2PM</div>
			<div class="col-sm-2">3PM</div>
			<div class="col-sm-2">4PM</div>
			<div class="col-sm-2">5PM</div>
			<div class="col-sm-2">6PM</div>
			<div class="col-sm-2">7PM</div>
			<div class="col-sm-2">8PM</div>
		</div>
	</div>
</c:forEach>

<script>
	$('#datepicker').datepicker({
		format : "dd/mm/yyyy"
	});
</script>
<script type="text/javascript"
	src="<c:url value="/js/booking.js" />">
</script>

