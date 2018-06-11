<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Make Booking</h3>
<form action="/action_page.php">

	<label>Choose Facility Type</label>
	<!-- The second value will be selected initially -->
	<select name="text">
		<!--Supplement an id here instead of using 'text'-->
		<option value="first">First Value</option>
		<option value="second" selected>Second Value</option>
		<option value="third">Third Value</option>
	</select> <label>Date</label> <input id="starttime" type="datetime-local">

	<br> <label>Choose Room</label>
	<!-- The second value will be selected initially -->
	<select name="text">
		<!--Supplement an id here instead of using 'text'-->
		<option value="first">First Value</option>
		<option value="second" selected>Second Value</option>
		<option value="third">Third Value</option>
	</select> <label>Start Time</label> <input id="starttime" type="datetime-local">

	<label>End Time</label> <input id="endtime" type="datetime-local">

	<br>
	<input type="submit" value="Book Now">
	<br>
	
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
