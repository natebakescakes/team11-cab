<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextPath}/home">Club
				Application for Booking</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="${contextPath}/home">Home</a></li>
				<li><a href="${contextPath}/facilities">Facilities</a></li>
				<li><a href="#">My Bookings</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="isAnonymous()">
					<li><a href="${contextPath}/login">Login/Sign Up</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<sec:authorize access="hasRole('ADMIN')">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"><i class="fa fa-gear"></i> Manage <i class="fa fa-caret-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="${contextPath}/admin/bookings/">Bookings</a></li>
								<li><a href="${contextPath}/admin/facilities/">Facilities</a></li>
								<li><a href="${contextPath}/admin/members/list">Members</a></li>
							</ul></li>
					</sec:authorize>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><i class="fa fa-user"></i> <sec:authentication
								property="principal.username" /> <i class="fa fa-caret-down"></i></a>
						<ul class="dropdown-menu">
							<li><a href="${contextPath}/user/profile">Edit Profile</a></li>
							<li role="separator" class="divider"></li>
							<li><form class="form-group" action="${contextPath}/logout"
									method="POST">
									<button class="form-control btn-link" type="submit">
										<i class="fa fa-sign-out"></i> Logout
									</button>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form></li>
						</ul></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>
