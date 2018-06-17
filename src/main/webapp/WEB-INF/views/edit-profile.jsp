<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<body>
	<div class="row">
		<div style="max-width: 300px; margin: auto">
			<form:form modelAttribute="member"
				action="${contextPath}/user/profile/edit" method="POST">
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
						<input type="email" class="form-control" id="email" name="email"
							placeholder="hello@example.com" value="${member.email}" />
					</div>
					<form:errors path="email" cssClass="form-text text-muted" />
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.firstName" var="firstName" />
					<input type="text" class="form-control" id="firstName"
						name="firstName" placeholder="${firstName}"
						value="${member.firstName}" />
					<form:errors path="firstName" cssClass="form-text text-muted" />
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.lastName" var="lastName" />
					<input type="text" class="form-control" id="lastName"
						name="lastName" placeholder="${lastName}"
						value="${member.lastName}" />
					<form:errors path="lastName" cssClass="form-text text-muted" />
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-birthday-cake"></i></span>
						<spring:message code="fieldLabel.dateOfBirth" var="dateOfBirth" />
						<input type="date" class="form-control" id="dob" name="dob"
							placeholder="${dateOfBirth}" value="${member.dob}" />
					</div>
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.address" var="address" />
					<textarea rows="3" class="form-control" id="address" name="address"
						placeholder="${address}">${member.address}</textarea>
				</div>
				<div class="form-group">
					<spring:message code="fieldLabel.contactNo" var="contactNo" />
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-phone"></i></span>
						<input type="tel" class="form-control" id="phone" name="phone"
							placeholder="${contactNo}" value="${member.phone}" />
					</div>
					<form:errors path="phone" cssClass="form-text text-muted" />
				</div>
				<div style="text-align: center">
					<input type="submit" class="btn btn-primary" value="Save" /> <a
						href="${contextPath}/user/profile" class="btn btn-default">Cancel</a>
				</div>
			</form:form>
		</div>
	</div>
</body>