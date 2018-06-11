<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Make Booking</h3>

<ul>
	<li>${ftype}</li>
	<li>${date}</li>
	<li>${room}</li>
	<li>${stime}</li>
	<li>${endtime}</li>
</ul>

<form action="" method="POST">
	<label>Choose Facility Type</label>
	<select name="ftype">
		<option value="first">First Value</option>
		<option value="second" selected>Second Value</option>
		<option value="third">Third Value</option>
	</select>
	
	<label>Date</label>
	<input name="date" type="datetime-local">

	<br>
	
	<label>Choose Room</label>
	<select name="room">
		<c:forEach var="facility" items="${facilityList}">
			<option value="${facility.facilityId}">${facility.facilityName}</option>
		</c:forEach>
	</select>
	
	<label>Start Time</label>
	<input name="stime" id="starttime" type="datetime-local">

	<label>End Time</label>
	<input name="endtime" id="endtime" type="datetime-local">

	<br> <input type="submit" value="Book Now"> <br>

	<!-- Generate tables for each room -->
	<label>Function Room 1</label>
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
</form>
