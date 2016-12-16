<div class="container">
	<c:choose>
		<c:when test="${!empty noProduct}">
			<h3 align="center">${noProduct}</h3>
			<br>
			<br>
			<br>
			<br>
		</c:when>
		<c:otherwise>
			<fieldset>
				<legend>My Cart</legend>
				<p>Here you can see your wishlist...</p>
				<c:if test="${!empty outOfStock}">
					<div class="alert alert-warning">
						<strong>${outOfStock}</strong>
					</div>
				</c:if>
				<div class="row">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Image</th>
								<th>Product</th>
								<th>Unit Price</th>
								<th>Quantity</th>
								<th>Total</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cartItems}" var="item">
								<tr>
									<td><img class="image-square" alt="no image available"
										src="${images}/product/${item.product.productId}.png"
										width="150" height="150"></td>
									<td>${item.product.name}</td>
									<td>&#8377; ${item.product.unitPrice}</td>
									<!-- <td><input type="number" id="quantity" name="quantity"
										value="${item.quantity}" min="1" max="5"></td>
									<td><a id="cartItemId"
										href="${contextPath}/user/cart/change" class="btn btn-warning"
										role="button"><span class="glyphicon glyphicon-pencil"></span>
											Change</a></td> -->
									<td><form action="${contextPath}/user/cart/change"
											method="post">
											<input type="hidden" value="${item.cartItemId}"
												name="cartItemId" /> <input type="number"
												value="${item.quantity}" name="quantity" min="1" max="5"
												class="form-control" /> <input type="submit"
												class="btn btn-md btn-warning" value="Change Quantity" />
										</form></td>
									<td>&#8377; ${item.totalPrice}</td>
									<td><a
										href="${contextPath}/user/cart/remove/${item.cartItemId}"
										class="btn btn-danger" role="button"> Remove</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5" align="right"><b>Grand Total</b></td>
								<td>&#8377; ${cart.grandTotal}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">
					<a href="${contextPath}/user/cart/remove/all"
						class="btn btn-danger" role="button"> Remove All</a> <a
						href="${contextPath}/product/allProducts" class="btn btn-success"
						role="button"> Continue Shopping...</a> <a class="pull-right"
						href="${contextPath}/cart_checkout" class="btn btn-success"
						role="button"> Checkout</a>
				</div>
			</fieldset>
		</c:otherwise>
	</c:choose>

</div>