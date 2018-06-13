<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<body>
	<div class="row">
		<div style="max-width: 300px; margin: auto">
			<form:form modelAttribute="member" action="${contextPath}/register"
				method="POST">
				<div class=" form-group">
					<spring:message code="fieldLabel.username" var="username" />
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" class="form-control" id="username"
							name="username" placeholder="${username}" autofocus />
					</div>
					<form:errors path="username" cssClass="form-text text-muted" />
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.password" var="password" />
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="password" class="form-control" id="password"
							name="password" placeholder="${password}" autofocus />
					</div>
					<form:errors path="password" cssClass="form-text text-muted" />
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
						<input type="email" class="form-control" id="email" name="email"
							placeholder="hello@example.com" />
					</div>
					<form:errors path="email" cssClass="form-text text-muted" />
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.firstName" var="firstName" />
					<input type="text" class="form-control" id="firstName"
						name="firstName" placeholder="${firstName}" />
					<form:errors path="firstName" cssClass="form-text text-muted" />
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.lastName" var="lastName" />
					<input type="text" class="form-control" id="lastName"
						name="lastName" placeholder="${lastName}" />
					<form:errors path="lastName" cssClass="form-text text-muted" />
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.dateOfBirth" var="dateOfBirth" />
					<input type="date" class="form-control" id="dob" name="dob"
						placeholder="${dateOfBirth}" />
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.address" var="address" />
					<textarea rows="3" class="form-control" id="address" name="address"
						placeholder="${address}"></textarea>
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.contactNo" var="contactNo" />
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-phone"></i></span>
						<input type="tel" class="form-control" id="phone" name="phone"
							placeholder="${contactNo}" />
					</div>
					<form:errors path="phone" cssClass="form-text text-muted" />
				</div>
				<div style="text-align: center">
					<input type="submit" class="btn btn-primary" value="Register" /> <br />
					<a href="${contextPath}/login" class="btn btn-link">I already
						have an account!</a>
				</div>
			</form:form>
		</div>
	</div>
</body>