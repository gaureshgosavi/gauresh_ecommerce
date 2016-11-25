
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
				<legend>Add New Supplier</legend>
				<form:form method="post" action="${contextPath}/admin/viewSuppliers/supplier/save"
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
						<form:input path="contactNo" type="number"
							cssClass="form-control" id="contact_no"
							placeholder="contact no" />
					</div>
					<div class="form-group">
						<c:if test="${empty supplier.name}">
							<a href="${contextPath}/admin/viewSuppliers/supplier/save"
								class="btn btn-primary" role="button">Add New Supplier</a>
						</c:if>
						<c:if test="${!empty supplier.name}">
							<a href="${contextPath}/admin/viewSuppliers/supplier/save"
								class="btn btn-primary" role="button">Update Supplier</a>
						</c:if>
					</div>
				</form:form>
			</fieldset>
		</div>
	</div>
	<!-- Supplier form-->
	<br>
	<hr>
	<h3>Suppliers</h3>
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
					<td><a href="${contextPath}/admin/viewSuppliers/edit/${supplier.id}"
						class="btn btn-link" role="button">Edit</a></td>
					<td><a href="${contextPath}/admin/viewSuppliers/delete/${supplier.id}"
						class="btn btn-link" role="button">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Supplier List -->

