<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div style="max-width: 300px; margin: auto">
		<h3 style="text-align: center;">Create New Facility Type</h3>
		<form:form modelAttribute="facilityType"
			action="${pageContext.request.contextPath}/admin/facilities/types/create" method="POST">
			<div class=" form-group">
				<input type="text" class="form-control" id="typeName"
					name="typeName" placeholder="Facility Type Name" autofocus />
				<form:errors path="typeName" cssClass="form-text text-muted" />
			</div>
			<div class="form-group">
				<textarea class="form-control" rows="3" id="description" name="description"
					placeholder="Description"></textarea>
				<form:errors path="description" cssClass="form-text text-muted" />
			</div>
			<div style="text-align: center">
				<input type="submit" class="btn btn-primary" value="Add Facility Type" />
			</div>
		</form:form>
	</div>
</div>

