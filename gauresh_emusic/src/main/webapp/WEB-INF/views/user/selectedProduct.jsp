<div class="container">
	<div class="row">
		<div class="col-md-6">
			<img class="image-square img-responsive" alt="image"
				src="${images}/product/${product.productId}.png" width="500px" height="500px">
		</div>

		<div class="col-md-6">
			<div class="container">
				<h2>${product.name}</h2>
				<br>
				<p>Description:${product.description}</p>
				<br>
				<p>
					<b>Price:${product.price}</b>
				</p>
				<br>
				<p>Quantity:<input type="number" name="quantity" size="20" min="1" max="5"></p>
				<br>
				<p>Category:${category.name}</p>
				<br>
				<p>Supplier:${supplier.name}</p>
				<br> <input type="number" name="quantity" min="1" max="5">
				<br> <a href="#" class="btn btn-warning" role="button"> Add
					to Cart</a> <a href="cart_checkout"
					class="btn btn-success" role="button"> Buy Now</a>
			</div>
		</div>
	</div>
</div>

