<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Facility List page</h3>
<a href="${pageContext.request.contextPath}/facility/create">Add
	Facility</a>
<table style="cellspacing: 2; cellpadding: 2; border: 1;">
	<thead>
		<tr class="listHeading">
			<th><spring:message code="fieldLabel.facilityId" /></th>
			<th><spring:message code="fieldLabel.facilityName" /></th>
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
				<td>${facility.location}</td>
				<td>${facility.description}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/facility/edit/${facility.facilityId}.html"><spring:message
							code="caption.edit" /></a></td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/facility/delete/${facility.facilityId}.html"><spring:message
							code="caption.delete" /></a></td>

			</tr>
		</c:forEach>
	</tbody>
</table>
