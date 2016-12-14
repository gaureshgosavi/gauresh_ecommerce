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
				<div>
					<c:if test="${empty product.name}">
						<legend>Add New Category</legend>
					</c:if>
					<c:if test="${!empty product.name}">
						<legend>Update Category</legend>
					</c:if>
				</div>
				<div>
					<c:if test="${empty product.name}">
						<p>Here you can add new category...</p>
					</c:if>
					<c:if test="${!empty product.name}">
						<p>Here you can update category...</p>
					</c:if>
				</div>
				<br>
				<c:choose>
					<c:when test="${!empty noCategory}">
						<h2>${noCategory}</h2>
					</c:when>
					<c:otherwise>
						<form:form method="post"
							action="${contextPath}/admin/viewCategories/category/save"
							modelAttribute="category" cssClass="form-vertical"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="name">Category name</label>
								<form:input path="name" type="text" cssClass="form-control"
									id="name" placeholder="Name" required="true" />
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
									<button type="submit" class="btn btn-success">Add New
										Category</button>
								</c:if>
								<c:if test="${!empty category.name}">
									<button type="submit" class="btn btn-success">Update
										Category</button>
								</c:if>
								<a href="${contextPath}/admin/viewCategories"
									class="btn btn-warning" role="button"> Clear </a>
							</div>
						</form:form>
					</c:otherwise>
				</c:choose>
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
				<th></th>
				<th>Name</th>
				<th>Description</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td><img src="${images}/category/${category.id}.png"
						class="img-rounded" alt="No Image Available" width="150"
						height="150"></td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a
						href="${contextPath}/admin/viewCategories/edit/${category.id}"
						class="btn btn-warning" role="button"><span
							class="glyphicon glyphicon-pencil"></span> Edit</a></td>
					<td><a
						href="${contextPath}/admin/viewCategories/delete/${category.id}"
						class="btn btn-danger" role="button"><span
							class="glyphicon glyphicon-trash"></span> Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Category List -->

