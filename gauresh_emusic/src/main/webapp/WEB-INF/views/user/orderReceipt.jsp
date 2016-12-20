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
					<b>Email: ${checkoutTemp.user.username}</b> <br> <b>Billing
						Address:</b> ${checkoutTemp.billingAddress.line1}, <br />
					${checkoutTemp.billingAddress.line2},<br>${checkoutTemp.billingAddress.city},
					<br>${checkoutTemp.billingAddress.state},<br>
					${checkoutTemp.billingAddress.country}-${checkoutTemp.billingAddress.zipCode}.<br>

				</p>
			</div>
			<div class="col-md-6">
				<h3>Payment Information</h3>
				<br>
				<p>
					<h5><b>ORDER ID</b>: ORD${checkoutTemp.orderDetails.orderId}</h5>
				<b>Total Amount:</b> &#8377;
				${checkoutTemp.orderDetails.grandTotal}/- <br> <b>Payment
					Status:</b> Done. <br> <b>Shipping Address:</b>
				${checkoutTemp.shippingAddress.line1}, <br />
				${checkoutTemp.shippingAddress.line2},<br>${checkoutTemp.shippingAddress.city},
				<br>${checkoutTemp.shippingAddress.state},<br>
				${checkoutTemp.shippingAddress.country}-${checkoutTemp.shippingAddress.zipCode}.<br>
				</P>
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
						<c:forEach items="${checkoutTemp.orderDetails.orderItems}"
							var="item">
							<tr>
								<td>${item.productName}</td>
								<td>&#8377; ${item.unitPrice}/-</td>
								<td>${item.quantity}</td>
								<td>&#8377; ${item.totalPrice}/-</td>
							</tr>

						</c:forEach>
						<tr>
							<td colspan="3" align="right">Grand Total</td>
							<td>&#8377; ${checkoutTemp.orderDetails.grandTotal}/-</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div align="center">
				<img src="${images}/thankyou.jpg" class="img-rounded" alt="ThankYou"
					width="304" height="236">
			</div>
			<h3 align="center">You will receive your order within six days.</h3>
			<p align="center">Keep Visiting</p>
		</div>
		<div class="row">
			<form id="orderReceipt" role="form-horizontal" method="post">
				<div class="form-group">
					<input type="submit" name="_eventId_finalHome"
						class="btn btn-md btn-success" value="Continue shopping...">
				</div>
			</form>
		</div>
	</div>
	<%@include file="../shared/footer.jsp"%>
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.js"></script>

</body>
</html>