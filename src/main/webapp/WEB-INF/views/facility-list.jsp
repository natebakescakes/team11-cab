<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Facility List page</h3>
<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.facilityId" /></th>
				<th><spring:message code="fieldLabel.facilityName" /></th>
				<th><spring:message code="fieldLabel.facilityType" /></th>
							</tr>
		</thead>
		<tbody>
			<c:forEach var="facility" items="${facilityList}">
				<tr class="listRecord">
					<td>${facility.facilityId}</td>
					<td>${facility.facilityName}</td>
					<td>${facility.facilityType.typeName}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>