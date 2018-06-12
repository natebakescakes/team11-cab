<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<body>
	<c:if test="${param.error != null}">
		<div class="row">
			<div class="alert alert-warning" role="alert">Invalid username
				and password.</div>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="row">
			<div class="alert alert-success" role="alert">You have been
				logged out.</div>
		</div>
	</c:if>

	<c:url value="/login" var="loginUrl" />

	<div class="row">
		<form action="${loginUrl}" method="post">
			<div class="form-group">
				<spring:message code="fieldLabel.username" var="username" />
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" id="username" class="form-control" name="username"
						placeholder="${username}" autofocus/>
				</div>
			</div>
			<div class="form-group">
				<spring:message code="fieldLabel.password" var="password" />
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="password" id="password" class="form-control" name="password"
						placeholder="${password}" />
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit" class="btn btn-primary">Sign In</button>
			<a href="${contextPath}/register" class="btn btn-primary">Register</a>
		</form>
	</div>
</body>