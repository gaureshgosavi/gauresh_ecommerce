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
			<div class="col-md-6">
				<img class="image-circle" alt="logo" src="${images}/logo.jpg"
					width="170" height="170">
			</div>
			<div class="col-md-6">
				<h3>Emu$ic</h3>
				<br>
				<p>
					<b>Address:</b> NIIT,<br>Near Ghatkopar Stn.,<br>Ghatkopar(E),<br>Mumbai-400092.
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p align="center">
					<mark>
						<b>Email: gauresh@emusic.com</b>
					</mark>
				</p>
			</div>
			<div class="col-md-6">
				<p align="center">
					<mark>
						<b>Contact No: 1800 9898 206/1800 9898 209</b>
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
					<b>Billing Address:</b> ${checkoutTemp.billingAddress.line1}, <br />
					${checkoutTemp.billingAddress.line2},<br>${checkoutTemp.billingAddress.city},
					<br>${checkoutTemp.billingAddress.state},<br>
					${checkoutTemp.billingAddress.country}-${checkoutTemp.billingAddress.zipCode}.<br>

				</p>
			</div>
			<div class="col-md-6">
				<h3>Payment Information</h3>
				<br>
				<p>
					<b>Total Amount:</b>${orderDetails.grandTotal} <br> <b>Payment
						Status:</b> Done. <br> <b>Shipping Address:</b>
					${checkoutTemp.shippingAddress.line1}, <br />
					${checkoutTemp.shippingAddress.line2},<br>${checkoutTemp.shippingAddress.city},
					<br>${checkoutTemp.shippingAddress.state},<br>
					${checkoutTemp.shippingAddress.country}-${checkoutTemp.shippingAddress.zipCode}.<br>
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
						<c:forEach items="${orderItems}" var="item">
							<tr>
								<td>${item.productName}</td>
								<td>item.</td>
								<td>${item.quantity}</td>
								<td>${item.totalPrice}</td>
							</tr>
							<tr>
								<td colspan="3" align="right">Grand Total</td>
								<td>${orderDetails.grandTotal}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<input type="submit" name="_eventId_cancel"
				class="btn btn-md btn-danger" value="Cancel"> <input
				type="submit" name="_eventId_finalHome"
				class="pull-right" class="btn btn-md btn-success"
				value="Continue shopping...">
		</div>
	</div>
	<%@include file="../shared/footer.jsp"%>
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.js"></script>

</body>
</html>