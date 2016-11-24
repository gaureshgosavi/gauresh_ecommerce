<div class="container">
	<div class="container col-md-4">
		<fieldset>
			<legend>Add New Product</legend>
			<form:form method="post" action="${contextPath}/admin/product/save"
				modelAttribute="product" styleClass="form-vertical">
				<div class="form-group">
					<label for="name">Product name</label>
					<form:input type="text" styleClass="form-control" path="name"
						id="name" placeholder="Name" />
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<form:textarea path="description" styleClass="form-control"
						rows="3" id="description" placeholder="Description"></form:textarea>
				</div>
				<div class="form-group">
					<label for="category">Category</label>
					<form:select path="" styleClass="form-control" id="category">
						<c:forEach items="${categoryList}" var="category">
							<form:option>${category.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label for="supplier">Supplier</label>
					<form:select path="" styleClass="selection form-control"
						name="supplier">
						<c:forEach items="${supplierList}" var="supplier">
							<form:option value="">${supplier.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label for="unit_price">Unit Price</label>
					<form:input path="unitPrice" type="number"
						styleClass="form-control" id="unit_price" placeholder="unit price" />
				</div>
				<div class="form-group">
					<label for="quantity">Quantity</label>
					<form:input path="quantity" type="number" styleClass="form-control"
						id="quantity" placeholder="Quantity" />
				</div>
				<div class="form-group">
					<label for="uploadfile">Upload File</label>
					<form:input path="" type="file" id="file" styleClass="form-control"
						placeholder="Upload file" />
				</div>
				<div class="form-group">
					<button type="submit" Class="btn btn-primary">Add Product</button>
				</div>
			</form:form>
		</fieldset>
	</div>
	<!-- product form -->


	<div class="container col-md-4">
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


	<div class="container col-md-4">
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
<!--  -->
<div class="container ">
	<hr>
	<h3>Products</h3>
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
 Product -->

<div class="container ">
	<hr>
	<h3>Categories</h3>
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


<div class="container ">
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