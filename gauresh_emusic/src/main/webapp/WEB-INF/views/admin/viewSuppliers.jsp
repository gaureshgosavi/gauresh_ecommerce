
<div class="container">
	<div class="row">
		<c:if test="${!empty msg}">
			<div class="alert alert-success" id="messageDelete-success">
				<strong>${msg}</strong>
			</div>
		</c:if>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<fieldset>
				<div>
					<c:if test="${empty product.name}">
						<legend>Add New Supplier</legend>
					</c:if>
					<c:if test="${!empty product.name}">
						<legend>Update Supplier</legend>
					</c:if>
				</div>
				<div>
					<c:if test="${empty product.name}">
						<p>Here you can add new supplier...</p>
					</c:if>
					<c:if test="${!empty product.name}">
						<p>Here you can update supplier...</p>
					</c:if>
				</div>
				<form:form method="post"
					action="${contextPath}/admin/viewSuppliers/supplier/save"
					modelAttribute="supplier" cssClass="form-vertical">
					<div class="form-group">
						<label for="name">Supplier name</label>
						<form:input path="name" type="text" cssClass="form-control"
							id="name" placeholder="Name" />
					</div>
					<form:input type="hidden" path="id" />
					<div class="form-group">
						<label for="email">Email ID</label>
						<form:input path="email" type="email" cssClass="form-control"
							id="email" placeholder="Email ID" />
					</div>
					<div class="form-group">
						<label for="contact_no">Contact No</label>
						<form:input path="contactNo" type="number" cssClass="form-control"
							id="contact_no" placeholder="contact no" />
					</div>
					<div class="form-group">
						<c:if test="${empty supplier.name}">
							<button type="submit" class="btn btn-primary">Add New
								Supplier</button>
						</c:if>
						<c:if test="${!empty supplier.name}">
							<button type="submit" class="btn btn-primary">Update
								Product</button>
						</c:if>
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-circle-arrow-left"></span> Back
						</button>
					</div>
				</form:form>
			</fieldset>
		</div>
	</div>
	<!-- Supplier form-->
	<br>
	<hr>
	<h3>Supplier List</h3>
	<table class="table table-responsive">
		<thead>
			<tr>
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
					<td>${supplier.name}</td>
					<td>${supplier.email}</td>
					<td>${supplier.contactNo}</td>
					<td><a
						href="${contextPath}/admin/viewSuppliers/edit/${supplier.id}"
						class="btn btn-default" role="button"><span
							class="glyphicon glyphicon-pencil"></span> Edit</a></td>
					<td><a
						href="${contextPath}/admin/viewSuppliers/delete/${supplier.id}"
						class="btn btn-default" role="button"> <span
							class="glyphicon glyphicon-trash"></span> Delete
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Supplier List -->

