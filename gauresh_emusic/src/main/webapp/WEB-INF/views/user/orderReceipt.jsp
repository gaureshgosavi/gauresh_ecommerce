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
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<img class="image-circle" alt="logo" src="${images}/logo.jpg"
					width="170" height="170">
			</div>
			<div class="col-md-6">
				<h3>Emu$ic</h3>
				<br>
				<p>Address:</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p align="center">
					<mark>
						<b>Email:</b>
					</mark>
				</p>
			</div>
			<div class="col-md-6">
				<p align="center">
					<mark>
						<b>Contact No:</b>
					</mark>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<h3>Client Information</h3>
				<br>
				<p>
					<b>Name:</b> <br> <b>Email:</b> <br> <b>Contact No:</b> <br>
					<b>Billing Address:</b>
				</p>
			</div>
			<div class="col-md-6">
				<h3>Payment Information</h3>
				<br>
				<p>
					<b>Total Amount:</b> <br> <b>Payment Status:</b> <br> <b>Payment
						Method:</b> <br> <b>Shipping Address:</b>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>product</th>
							<th>Unit Price</th>
							<th>Quantity</th>
							<th>Total</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="3" align="right">Grand Total</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<input type="submit" name="_eventId_cancel"
				class="btn btn-md btn-danger" value="Cancel"> <input
				type="submit" name="_eventId_submitConfirmCheckout"
				class="pull-right" class="btn btn-md btn-success"
				value="Place Order">
		</div>
	</div>
	<%@include file="../shared/footer.jsp"%>
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.js"></script>

</body>
</html>