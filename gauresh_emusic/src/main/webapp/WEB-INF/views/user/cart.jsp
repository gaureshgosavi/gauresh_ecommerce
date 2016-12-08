<div class="container">
	<c:choose>
		<c:when test="${!empty noProduct}">
			<h3 align="center">${noProduct}</h3><br><br><br><br>
		</c:when>
		<c:otherwise>
			<fieldset>
				<legend>My Cart</legend>
				<p>Here you can see your wishlist...</p>
				<div class="row">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Image</th>
								<th>Product</th>
								<th>Unit Price</th>
								<th>Quantity</th>
								<th>Action</th>
								<th>Total</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cartItems}" var="item">
								<tr>
									<td><img class="image-square" alt="no image available"
										src="" width="150" height="150"></td>
									<td>${item.product.name}</td>
									<td>${item.product.unitPrice}</td>
									<td><input type="number" id="quantity" name="quantity"
										min="1" max="5"></td>
									<td><a id="cartItemId"
										href="${contextPath}/user/cart/change" class="btn btn-default"
										role="button"><span class="glyphicon glyphicon-pencil"></span>
											Change</a></td>
									<td>${item.totalPrice}</td>
									<td><a href="#" class="btn btn-danger" role="button">
											Remove</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="4" align="right"><b>Grand Total</b></td>
								<td>&#8377; ${cart.grandTotal}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">
					<a href="#" class="btn btn-danger" role="button"> Remove All</a> <a
						class="pull-right" href="cart_checkout" class="btn btn-success"
						role="button"> Checkout</a>
				</div>
			</fieldset>
		</c:otherwise>
	</c:choose>

</div>