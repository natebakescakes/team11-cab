<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div style="max-width: 300px; margin: auto">
			<c:if test="${message != null}">
				<div class="row">
					<div class="alert alert-success" role="alert">${message}</div>
				</div>
			</c:if>
		</div>
	</div>

	<h3>Manage Facilities</h3>
	<div class="row">
		<a href="${pageContext.request.contextPath}/admin/facilities/create" class="btn btn-primary">
			Add New Facility
		</a>
		<a href="${pageContext.request.contextPath}/admin/facilities/types" class="btn btn-primary">
			Manage Facility Types
		</a>
	</div>

	<div class="row">
		<table id="myFacTable" style="width: 100%"
			class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Facility ID</th>
					<th>Facility Name</th>
					<th>Facility Type</th>
					<th>Location</th>
					<th>Description</th>
					<th>Status</th>
					<th>Edit</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>