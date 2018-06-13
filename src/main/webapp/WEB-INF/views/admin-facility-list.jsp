
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Facility List page</h3>

<a href="${pageContext.request.contextPath}/facility/admin/create">Add
	Facility</a>
<c:if test="${fn:length(facilityList) gt 0}">
	<table style="width:100%" class="table table-striped table-bordered">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.facilityId" /></th>
				<th><spring:message code="fieldLabel.facilityName" /></th>
				<th><spring:message code="fieldLabel.facilityType" /></th>
				<th><spring:message code="fieldLabel.location" /></th>
				<th><spring:message code="fieldLabel.description" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="facility" items="${facilityList}">
				<tr class="listRecord">
					<td>${facility.facilityId}</td>
					<td>${facility.facilityName}</td>
					<td>${facility.facilityType.typeName}</td>
					<td>${facility.location}</td>
					<td>${facility.description}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/facility/admin/edit/${facility.facilityId}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/facility/admin/delete/${facility.facilityId}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</c:if>
