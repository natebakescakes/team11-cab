<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Facility Page</title>

<link href="../../css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-1.11.0.min.js"></script>

<script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<c:forEach var="type" items="${typeList}">
		<div class="row">
			<h2>
				<!--  <a
					href="${pageContext.request.contextPath}/booking/typeid=${type.typeId}"> -->
				${type.typeName}
				<!-- </a> -->
			</h2>
			<p>${type.description}</p>
		</div>
		<div class="row">
			<c:forEach var="facility" items="${type.facilities}">
				<div class="col-xs-6 col-sm-4 col-md-3">
					<div class="thumbnail">
						<c:if test="${facility.status!=0}">
							<!--  <a
								href="${pageContext.request.contextPath}/booking/tid=${type.typeId}/fid=${facility.facilityId}"> -->
							<img
								src="${pageContext.request.contextPath}/image/${facility.facilityType.typeId}.jpg"
								height="500" class="img-thumbnail">
							<!-- </a> -->
						</c:if>

						<c:if test="${facility.status!=1}">
							<img
								src="${pageContext.request.contextPath}/image/${facility.facilityType.typeId}.jpg"
								height="500" class="img-thumbnail">
						</c:if>


						<div class="caption" style="text-align: center">
							<h3>${facility.facilityName}</h3>
							<p>${facility.description}</p>
							<p>
								<c:if test="${facility.status!=0}">
									<fmt:formatDate value="${dateTomorrow}" pattern="yyyy-MM-dd" type="date"
										var="dateNow" />
									<form:form action="${pageContext.request.contextPath}/booking"
										class="form-group" method="POST">
										<input hidden="true" type="radio" name="typeId"
											value="${type.typeId}" id="typeId" checked="checked" />
										<input hidden="true" name="date" type="date"
											value="${dateNow}" />
										<input hidden="true" name="stime" id="stime" value="9:00" />
										<input hidden="true" name="endtime" id="endtime" value="10:00" />
										<button type="submit" class="btn btn-primary" name="refresh">
											<i class="fa fa-bookmark-o"></i> Book Now
										</button>
									</form:form>
								</c:if>

								<c:if test="${facility.status!=1}">
									<i class="fa fa-ban"></i> Not Available Now
								</c:if>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:forEach>
</body>

</html>