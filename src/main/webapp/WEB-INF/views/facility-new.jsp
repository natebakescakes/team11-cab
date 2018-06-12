<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Facility page</h3>
<form:form method="POST" modelAttribute="facility"
	action="${pageContext.request.contextPath}/facility/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.facilityId" /></td>
				<td><form:input path="facilityId" /></td>
				<td><form:errors path="facilityId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.facilityName" /></td>
				<td><form:input path="facilityName" /></td>
				<td><form:errors path="facilityName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.facilityType" /></td>
				<td><form:input path="facilityType" /></td>
				<td><form:errors path="facilityType" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.location" /></td>
				<td><form:input path="location" /></td>
				<td><form:errors path="location" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.description" /></td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

