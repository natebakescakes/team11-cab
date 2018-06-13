<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
			<h2>${type.typeName}</h2>
			<p>${type.description}</p>
		</div>
		<div class="row">
			<c:forEach var="facility" items="${type.facilities}">
				<div class="col-xs-6 col-sm-4 col-md-3">
					<div class="thumbnail">
						<img
							src="${pageContext.request.contextPath}/image/${facility.facilityType.typeId}.jpg"
							height="500" class="img-thumbnail">
						<div class="caption" style="text-align: center">
							<h3>${facility.facilityName}</h3>
							<p>${facility.description}</p>
							<p>
								<a href="${pageContext.request.contextPath}/booking"
									class="btn btn-primary" role="button"><i
									class="fa fa-bookmark-o"></i> Book Now</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:forEach>
</body>

</html>