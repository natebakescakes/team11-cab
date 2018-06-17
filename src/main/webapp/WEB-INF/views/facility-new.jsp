<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div style="max-width: 300px; margin: auto">
		<h3 style="text-align: center;">Create New Facility</h3>
		<form:form modelAttribute="facility"
			action="${pageContext.request.contextPath}/admin/facilities/create" method="POST">
			<div class=" form-group">
				<spring:message code="fieldLabel.facilityName" var="facilityName" />
				<input type="text" class="form-control" id="facilityName"
					name="facilityName" placeholder="${facilityName}" autofocus />
				<form:errors path="facilityName" cssClass="form-text text-muted" />
			</div>
			<div class="form-group">
				<form:select cssClass="form-control" path="facilityType.typeId">
					<form:option value="0" label="Please select a Facility Type"/>
					<form:options items="${facTypeList}" itemValue="typeId"
						itemLabel="typeName" />
				</form:select>
				<form:errors path="facilityType.typeName"
					cssClass="form-text text-muted" />
			</div>
			<div class="form-group">
				<spring:message code="fieldLabel.location" var="location" />
				<input type="text" class="form-control" id="location"
					name="location" placeholder="${location}" />
			</div>
			<form:errors path="location" cssClass="form-text text-muted" />
			<div class="form-group">
				<spring:message code="fieldLabel.description" var="description" />
				<textarea class="form-control" rows="3" id="description" name="description"
					placeholder="${description}"></textarea>
				<form:errors path="description" cssClass="form-text text-muted" />
			</div>
			<div style="text-align: center">
				<input type="submit" class="btn btn-primary" value="Add Facility" />
			</div>
		</form:form>
	</div>
</div>

