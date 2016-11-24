
	<div class="container col-md-6 offset-md-3">
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