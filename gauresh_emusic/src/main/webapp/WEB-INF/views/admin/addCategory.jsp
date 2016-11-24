<div class="container col-md-6 offset-md-3">
		<fieldset>
			<legend>Add New Category</legend>
			<form:form method="post" action="${contextPath}/admin/category/save"
				modelAttribute="category" styleClass="form-vertical">
				<div class="form-group">
					<label for="name">Category name</label>
					<form:input path="name" type="text" styleClass="form-control"
						id="name" placeholder="Name" />
				</div>
				<div class="form-group">
					<label for="description">Description<label> <form:textarea
								path="description" styleClass="form-control" rows="3"
								id="description" placeholder="Description"></form:textarea>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Add Category</button>
				</div>
			</form:form>
		</fieldset>
	</div>
	<!-- category form -->