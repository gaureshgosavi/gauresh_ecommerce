<div class="container">
	<a href="${contextPath}/admin/viewCategories/addCategory"
		class="btn btn-inverse">Add New Category</a>
		<br>
		<hr>
	<h3>Categories</h3>
	<p>Here you can see all categories...</p>
	<table class="table table-responsive">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="#" class="btn btn-link" role="button">Edit</a></td>
					<td><a href="#" class="btn btn-link" role="button">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Category -->