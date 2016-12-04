<div class="container">
	<div class="row">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td><img src="${images}/product/${product.productId}.png"
							class="img-rounded" alt="No Image Available" width="150"
							height="150"></td>
						<td>${product.name}</td>
						<td><input type="submit" name="" class="btn btn-success"
							value="View Product" size="30"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>