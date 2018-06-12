<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<body>
	<c:url value="/register" var="registerUrl" />

	<div class="row">
		<form:form modelAttribute="user" action="${contextPath}/register"
			method="POST">
			<div class=" form-group">
				<spring:message code="fieldLabel.username" var="username" />
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" class="form-control" name="${user.username}"
						value="${status.value}" placeholder="${username}" autofocus />
				</div>
			</div>
			<div class="form-group">
				<spring:message code="fieldLabel.password" var="password" />
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span>
					<spring:bind path="userDto.password">
						<input type="text" class="form-control"
							name="${status.expression}" value="${status.value}"
							placeholder="${password}" autofocus />
					</spring:bind>
				</div>
			</div>
			<!--
			<div class="form-group">
				<spring:message code="fieldLabel.confirmPassword" var="password" />
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span>
					<spring:bind path="user.password">
						<input type="password" class="form-control"
							name="${status.expression}" value="${status.value}"
							placeholder="${password}" autofocus />
					</spring:bind>
				</div>
			</div>
			 -->
			<div class="form-group">
				<spring:message code="fieldLabel.email" var="email" />
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
					<spring:bind path="member.email">
						<input type="email" value="${status.value}" class="form-control"
							name="${status.expression}" placeholder="hello@example.com" />
					</spring:bind>
				</div>
			</div>
			<div class="form-group">
				<spring:message code="fieldLabel.firstName" var="firstName" />
				<spring:bind path="member.firstName">
					<input type="text" value="${status.value}" class="form-control"
						name="${status.expression}" placeholder="${firstName}" />
				</spring:bind>
			</div>
			<div class="form-group">
				<spring:message code="fieldLabel.lastName" var="lastName" />
				<spring:bind path="member.lastName">
					<input type="text" value="${status.value}" class="form-control"
						name="${status.expression}" placeholder="${lastName}" />
				</spring:bind>
			</div>
			<div class="form-group">
				<spring:message code="fieldLabel.dateOfBirth" var="dateOfBirth" />
				<spring:bind path="member.dob">
					<input type="date" value="${status.value}" class="form-control"
						name="${status.expression}" placeholder="${dateOfBirth}" />
				</spring:bind>
			</div>
			<div class="form-group">
				<spring:message code="fieldLabel.address" var="address" />
				<spring:bind path="member.address">
					<textarea rows="3" class="form-control" name="${status.expression}"
						placeholder="${address}"></textarea>
				</spring:bind>
			</div>
			<div class="form-group">
				<spring:message code="fieldLabel.contactNo" var="contactNo" />
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-phone"></i></span>
					<spring:bind path="member.phone">
						<input type="tel" value="${status.value}" class="form-control"
							name="${status.expression}" placeholder="${contactNo}" />
					</spring:bind>
				</div>
			</div>
			<input type="submit" class="btn btn-primary" value="Register" />
			<a href="${contextPath}/login" class="btn btn-link">I already
				have an account!</a>
		</form:form>
	</div>
</body>