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
				<form:form method="post"
					action="${contextPath}/admin/viewCategories/category/save"
					modelAttribute="category" cssClass="form-vertical" enctype="multipart/form-data">
					<div class="form-group">
						<label for="name">Category name</label>
						<form:input path="name" type="text" cssClass="form-control"
							id="name" placeholder="Name" />
					</div>
					<form:input type="hidden" path="id" />
					<div class="form-group">
						<label for="description">Description</label>
								<form:textarea path="description" cssClass="form-control"
									rows="3" id="description" placeholder="Description"></form:textarea>
					</div>
					<div class="form-group">
						<label for="uploadfile">Upload File</label>
						<form:input path="image" type="file" id="file"
							cssClass="form-control" placeholder="Upload file" />
					</div>
					<div class="form-group">
						<c:if test="${empty category.name}">
							<button type="submit" class="btn btn-primary">Add New
								Category</button>
						</c:if>
						<c:if test="${!empty category.name}">
							<button type="submit" class="btn btn-primary">Update
								Category</button>
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
					<td><a
						href="${contextPath}/admin/viewCategories/edit/${category.id}"
						class="btn btn-link" role="button">Edit</a></td>
					<td><a
						href="${contextPath}/admin/viewCategories/delete/${category.id}"
						class="btn btn-link" role="button">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Category List -->

