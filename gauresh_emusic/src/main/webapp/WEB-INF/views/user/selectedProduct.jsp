<div class="container">
	<div class="col-md-6">
		<img class="image-square img-responsive" alt="image"
			src="${images}/product/${product.productId}.png" width="500px"
			height="500px">
	</div>

	<div class="col-md-6">
		<h3>${product.name}</h3>
		<br>
		<p>
			<b>Description:</b> ${product.description}
		</p>
		<br>
		<p>
			<b>Price: <i class="fa fa-inr"></i>${product.unitPrice}</b>
		</p>
		<br>
		<p>
			<b>Quantity:</b> <input type="number" name="quantity" size="20"
				value="1" min="0" max="1">
		</p>
		<br>
		<p>
			<b>Category:</b> ${category.name}
		</p>
		<br>
		<p>
			<b>Supplier:</b> ${supplier.name}
		</p>
		<br> <a href="${contextPath}/user/cart/add/${product.productId}"
			class="btn btn-success" role="button"> Add to Cart</a> <a
			href="${contextPath}/product/allProducts" class="btn btn-warning"
			role="button"> Back</a>
	</div>
</div>

