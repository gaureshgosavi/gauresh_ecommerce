<div class="container">
	<a href="${contextPath}/admin/viewCategories/addCategory"
		class="btn btn-inverse">Add New Supplier</a>
		<br>
		<hr>
	<h3>Suppliers</h3>
	<table class="table table-responsive">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Contact No</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.email}</td>
					<td>${supplier.contactNo}</td>
					<td><a href="#" class="btn btn-link" role="button">Edit</a></td>
					<td><a href="#" class="btn btn-link" role="button">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Supplier -->