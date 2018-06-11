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
<h3>Member List page</h3>


<%-- 	<c:if test="${fn:length(members) gt 0}"> --%>
<!-- 	<table style="cellspacing: 2; cellpadding: 2; border: 1;"> -->
<!-- 		<thead> -->
<!-- 			<tr class="listHeading"> -->
<%-- 				<th><spring:message code="fieldLabel.userId" /></th> --%>
<%-- 				<th><spring:message code="fieldLabel.firstName" /></th> --%>
<%-- 				<th><spring:message code="fieldLabel.lastName" /></th> --%>
				
				
<!-- 			</tr> -->
<!-- 		</thead> -->
<!-- 		<tbody> -->
<%-- 			<c:forEach var="member" items="${members}"> --%>
<!-- 				<tr class="listRecord"> -->
<%-- 					<td>${member.userId}</td> --%>
<%-- 					<td>${member.firstName}</td> --%>
<%-- 					<td>${member.lastName}</td> --%>
					
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</tbody> -->
<!-- 	</table> -->
<%-- </c:if> --%>

	<div class="container">

		<div class="row" style="max-width:100%">
			<div class="centered" style="align:center; width:80%"  >

				<table id="myTable" style="width:100%" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>FIRST NAME</th>
							<th>LAST NAME</th>
							<th>EMAIL</th>
							<th>ADDRESS</th> 
						</tr>

					</thead>
				</table>

			</div>

		</div>
	</div>


</body>
</html>