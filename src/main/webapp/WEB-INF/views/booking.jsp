<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Make Booking</h3>

<c:if test="${bookingSuccess == true}">
	<div class="alert alert-success">
		Booking Successful!
	</div>
</c:if>
<c:if test="${bookingSuccess == false}">
	<div class="alert alert-danger">
		There is already a booking at that slot...
	</div>
</c:if>

<div class="form-group">
<form:form action="" method="POST">
	<div class="row">
		<div class="col-md-5">
			<label>Choose Facility Type</label>
			<select name="typeId"
				class="form-control">
				<option value="-1" selected disabled hidden>- Select a
					Facility Type -</option>
				<c:forEach var="facilityType" items="${ftypes}">
					<option value="${facilityType.typeId}"
						${facilityType.typeId == typeId ? 'selected="selected"' : ''}>
						${facilityType.typeName}</option>
				</c:forEach>
			</select>
			<input type="submit" name="refresh" value="Refresh">
			<br>
			<label>Choose Facility</label>
			<select id="choose-room" name="facility" class="form-control">
				<c:forEach var="facility" items="${facilities}">
					<option value="${facility.facilityId}">${facility.facilityName}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-md-5">
			<label>Date</label> <input id="datepicker" name="date" type="text"
				class="form-control" value="${date}">
			<label>Start Time</label>
			<input name="stime" id="starttime" type="time" step=3600 value="${stime}">
			<label>End Time</label>
			<input name="endtime" id="endtime" type="time" step=3600 alue="${endtime}">
		</div>
		<div class="col-md-2">
			<input class="btn btn-primary btn-block" type="submit" name="submit" value="Submit">
		</div>
	</div>
</form:form>
</div>

<!-- Generate tables for each facility -->
<c:forEach var="facilitySchedule" items="${facilitySchedules}">
	<h4>${facilitySchedule.facilityName}</h4>
	<div class="container booking-grid">
		<div class="row" data-value="${facilitySchedule.facilityId}">
			<c:forEach var="schedule" items="${facilitySchedule.schedule}">
				<div class="col-sm-2 ${schedule.booked ? 'booked' : ''}">${schedule.slotName}</div>
			</c:forEach>
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

