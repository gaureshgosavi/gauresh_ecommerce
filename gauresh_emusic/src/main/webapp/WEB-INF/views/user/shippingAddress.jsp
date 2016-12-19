<%--ALL THE TAG LIBRARIES INCLUDED HERE --%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../shared/header.jsp"%>
</head>
<body>
	<%@include file="../shared/webflowbar.jsp"%>
	<div class="container">
		<div class="row">

			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-primary">
					<div class="panel-heading">Shipping Address</div>
					<div class="panel-body ship">
						<form:form method="post" cssClass="form-vertical"
							modelAttribute="shippingAddress">
							<div class="form-group">
								<label for="line1">Line 1</label>

								<form:input path="line1" type="text" id="line1"
									class="form-control" placeholder="Address Line 1"
									required="true" />

							</div>
							<div class="form-group">
								<label for="line2">Line 2</label>

								<form:input path="line2" type="text" cssClass="form-control"
									placeholder="Address Line 2" required="true" />

							</div>
							<div class="form-group">
								<label for="city">City</label>

								<form:input path="city" type="text" cssClass="form-control"
									placeholder="City" required="true" />

							</div>
							<div class="form-group">
								<label for="state">State</label>

								<form:input path="state" type="text" cssClass="form-control"
									placeholder="State" required="true" />
							</div>

							<div class="form-group">
								<label for="country">Country</label>

								<form:input path="country" type="text" cssClass="form-control"
									placeholder="Country" required="true" />
							</div>

							<div class="form-group">
								<label for="zipCode">Zip code</label>

								<form:input path="zipCode" type="text" cssClass="form-control"
									placeholder="Zip code" required="true" />
							</div>

							<div align="center">
								<input type="submit" name="_eventId_submitShippingAddress"
									class="btn btn-md btn-success" value="Save"> <input
									type="submit" name="_eventId_cancel"
									class="btn btn-md btn-danger" value="Cancel">

							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../shared/footer.jsp"%>
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.js"></script>

</body>
</html>