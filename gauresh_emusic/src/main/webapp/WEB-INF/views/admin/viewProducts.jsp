<div class="container ">
	<a href="${contextPath}/admin/viewProducts/addProduct"
		class="btn btn-inverse">Add New Product</a>
		<br>
		<hr>
	<h3>Products</h3>
	<p>Here you can see all products...</p>
	<table class="table table-responsive">
		<thead>
			<tr>
				<th>ProductID</th>
				<th>CategoryID</th>
				<th>SupplierID</th>
				<th>Name</th>
				<th>Description</th>
				<th>UnitPrice</th>
				<th>Quantity</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.productId}</td>
					<td>${product.categoryId}</td>
					<td>${product.supplierId}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.unitPrice}</td>
					<td>${product.quantity}</td>
					<td><a href="#" class="btn btn-link" role="button">Edit</a></td>
					<td><a href="#" class="btn btn-link" role="button">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Product -->