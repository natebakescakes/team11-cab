<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<%@ include file="Header.jsp"%>
<!-- <c:url value="/css/simple.css" var="ss" /> 
<link rel="stylesheet" type="text/css" href="${ss}" /> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="STYLESHEET" type="text/css"
	href="<c:url value="/css/dataTables.bootstrap.css" />" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.dataTables.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/dataTables.bootstrap.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/cab.js" />"></script>

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
