<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta id="_csrf" name="_csrf" content="${_csrf.token}" />
<meta id="_csrf_header" name="_csrf_header"
	content="${_csrf.headerName}" />
<%@ include file="Header.jsp"%>
<!-- <c:url value="/css/simple.css" var="ss" /> 
<link rel="stylesheet" type="text/css" href="${ss}" /> -->
<!--  Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"href="<c:url value="/css/dataTables.bootstrap.css" />" />
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- DatePicker -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker3.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/dataTables.bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/app.css" />" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
	
<!-- Timepicker -->
<script
		src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	
<!-- Slick Slider -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/slick/slick-theme.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/slick/slick.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/slick/slick.min.js"></script>
<!-- data Tables -->
<script type="text/javascript" src="<c:url value="/js/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/dataTables.bootstrap.js" />"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/datejs/1.0/date.min.js"/></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.77/jquery.form-validator.min.js"/></script>

<script type="text/javascript" src="<c:url value="/js/cab.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/cabfac.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/cabbooking.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/cabmybooking.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/facilityTypes.js" />"></script>

<script>
window.contextRoot='${contextRoot}';
</script>
<dec:head />
</head>
<body>
	<div class="container">
		<%@ include file="Menu.jsp"%>
		<dec:body />
	</div>

	<!-- ======== Footer ======== -->
	<div id="footer" align="center">
		<hr>
		<small> &copy; ISS NUS SA46 Team 11 </small>
	</div>

</body>
</html>