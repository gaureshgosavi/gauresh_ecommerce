<div class="container col-md-6 offset-md-3">
		<fieldset>
			<legend>Add New Supplier</legend>
			<form:form method="post" action="${contextPath}/admin/product/save"
				modelAttribute="supplier" styleClass="form-vertical">
				<div class="form-group">
					<label for="name">Supplier name</label>
					<form:input path="name" type="text" styleClass="form-control"
						id="name" placeholder="Name" />
				</div>
				<div class="form-group">
					<label for="email">Email ID</label>
					<form:input path="email" type="email" styleClass="form-control"
						id="email" placeholder="Email ID" />
				</div>
				<div class="form-group">
					<label for="contact_no">Contact No</label>
					<form:input path="contactNo" type="number"
						styleClass="form-control" id="contact_no" placeholder="contact no" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Add Supplier</button>
				</div>
			</form:form>
		</fieldset>
	</div>
	<!-- Supplier -->
</div>