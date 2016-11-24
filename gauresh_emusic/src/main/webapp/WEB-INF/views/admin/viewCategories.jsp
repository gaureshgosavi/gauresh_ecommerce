<div class="container">
	<div class="row">
		<c:if test="${!empty msg}">
			<div class="alert alert-success" id="success">
				<strong>${msg}</strong>
			</div>
		</c:if>
	</div>
	<div class="row">
		<div class="container col-md-6 col-md-offset-3">
			<fieldset>
				<legend>Add New Category</legend>
				<p>Here you can add new category...</p>
				<br>
				<form:form method="post" action="${contextPath}/admin/category/add"
					modelAttribute="category" cssClass="form-vertical">
					<div class="form-group">
						<label for="name">Category name</label>
						<form:input path="name" type="text" cssClass="form-control"
							id="name" placeholder="Name" />
					</div>
					<div class="form-group">
						<label for="description">Description<label> <form:textarea
									path="description" cssClass="form-control" rows="3"
									id="description" placeholder="Description"></form:textarea>
					</div>
					<div class="form-group">
						<c:if test="${empty category.name}">
							<a href="${contextPath}/admin/viewCategories/add"
								class="btn btn-primary" role="button">Add New Category</a>
						</c:if>
						<c:if test="${!empty category.name}">
							<a href="${contextPath}/admin/viewCategories/update"
								class="btn btn-primary" role="button">Update Category</a>
						</c:if>

					</div>
				</form:form>
			</fieldset>
		</div>
	</div>
	<!-- category form -->
	<br>
	<hr>
	<h3>Categories</h3>
	<p>Here you can see all categories...</p>
	<table class="table table-responsive">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="${contextPath}/admin/viewCategories/edit/${category.id}"
						class="btn btn-link" role="button">Edit</a></td>
					<td><a href="${contextPath}/admin/viewCategories/delete/${category.id}"
						class="btn btn-link" role="button">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Category List -->

