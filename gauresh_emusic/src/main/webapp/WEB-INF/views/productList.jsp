<div class="container">
	<div class="row">
		<c:if test="${!empty msg}">
			<div class="alert alert-default" id="errorMessage">
				<strong>${msg}</strong>
			</div>
		</c:if>
	</div>
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
						<!--  <td><input type="submit" href="${contextPath}/product/productDetail/${productId}" class="btn btn-success"
							value="View Product" size="30"></td> -->
							<td><a href="${contextPath}/product/productDetail/${product.productId}" class="btn btn-success" role="button">View Product</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>