<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<c:choose>
		<c:when test="${user.role eq 'admin'}">
			<%@ include file="header-admin.jsp"%>
		</c:when>
		<c:when test="${user.role eq 'member'}">
			<%@ include file="header-member.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="header-guest.jsp"%>
		</c:otherwise>
	</c:choose>
<c:url value="/css/simple.css" var="ss"/>
<link rel="STYLESHEET" type="text/css"
	href="${ss}" />
<dec:head />
</head>
<body>
	<table style="width: 100%">
		<tr>
			<td style="width: 180; border: 1" valign="top">
				<div>
					
					<%@ include file="Menu.jsp"%>
				</div>
			</td>
			<td>
				<div>
					<h3>
						<spring:message code="${bodyTitle}" />
					</h3>
					<dec:body />
				</div>
			</td>
		</tr>
	</table>
	
	<!-- ======== Footer ======== -->
				<div id="footer" align="center">
				  <hr>
					<small> &copy; ISS NUS SA46 Team 11 </small>
				</div>
</body>
</html>
