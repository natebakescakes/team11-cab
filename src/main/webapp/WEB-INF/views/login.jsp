<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body onload='document.f.j_username.focus();'>
	<div class="row">
		<c:if test="${param.error != null}">
			<p>Invalid username and password.</p>
		</c:if>
		<c:if test="${param.logout != null}">
			<p>You have been logged out.</p>
		</c:if>

		<c:url value="/login" var="loginUrl" />

		<form action="${loginUrl}" method="post">
			<div class="form-group">
				<spring:message code="fieldLabel.username" var="username" />
				<label for="username">${username}: </label> <input type="text"
					id="username" class="form-control" name="username"
					placeholder="${username}" />
			</div>
			<div class="form-group">
				<spring:message code="fieldLabel.password" var="password" />
				<label>${password}: </label> <input type="password" id="password"
					class="form-control" name="password" placeholder="${password}" />
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>