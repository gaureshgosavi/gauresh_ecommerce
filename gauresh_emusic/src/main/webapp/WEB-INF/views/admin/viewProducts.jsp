
<div class="container ">
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
						<legend>Add New Product</legend>
					</c:if>
					<c:if test="${!empty product.name}">
						<legend>Update Product</legend>
					</c:if>
				</div>
				<div>
					<c:if test="${empty product.name}">
						<p>Here you can add new product...</p>
					</c:if>
					<c:if test="${!empty product.name}">
						<p>Here you can Update product...</p>
					</c:if>
				</div>
				<c:choose>
					<c:when test="${!empty noProduct}">
						<h2>${noProduct}</h2>
					</c:when>
					<c:otherwise>
						<form:form method="post"
							action="${contextPath}/admin/viewProducts/product/save"
							modelAttribute="product" cssClass="form-vertical"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="name">Product name</label>
								<form:input type="text" cssClass="form-control" path="name"
									id="name" placeholder="Name" required="true" />
								<form:input type="hidden" path="productId" />
							</div>
							<div class="form-group">
								<label for="description">Description</label>
								<form:textarea path="description" cssClass="form-control"
									rows="3" id="description" placeholder="Description"></form:textarea>
							</div>
							<div class="form-group">
								<label for="category">Category</label>
								<form:select path="categoryId" cssClass="form-control"
									id="category">
									<c:forEach items="${categoryList}" var="category">
										<form:option value="${category.id}">${category.name}</form:option>
									</c:forEach>
								</form:select>
							</div>
							<div class="form-group">
								<label for="supplier">Supplier</label>
								<form:select path="supplierId" cssClass="selection form-control"
									name="supplier">
									<c:forEach items="${supplierList}" var="supplier">
										<form:option value="${supplier.id}">${supplier.name}</form:option>
									</c:forEach>
								</form:select>
							</div>
							<div class="form-group">
								<label for="unit_price">Unit Price</label>
								<form:input path="unitPrice" type="number"
									cssClass="form-control" id="unit_price"
									placeholder="unit price" required="true" />
							</div>
							<div class="form-group">
								<label for="quantity">Quantity</label>
								<form:input path="quantity" type="number"
									cssClass="form-control" id="quantity" placeholder="Quantity"
									required="true" />
							</div>
							<div class="form-group">
								<label for="uploadfile">Upload File</label>
								<form:input path="image" type="file" id="file"
									cssClass="form-control" placeholder="Upload file" />
							</div>
							<div class="form-group">
								<c:if test="${empty product.name}">
									<button type="submit" class="btn btn-success">Add New
										Product</button>
								</c:if>
								<c:if test="${!empty product.name}">
									<button type="submit" class="btn btn-success">Update
										Product</button>
								</c:if>
								<a href="${contextPath}/admin/viewProducts"
									class="btn btn-warning" role="button"> Clear </a>
							</div>
						</form:form>
					</c:otherwise>
				</c:choose>
			</fieldset>
		</div>

	</div>
	<!-- product form -->
	<br>
	<hr>
	<h3>Products</h3>
	<p>Here you can see all products...</p>
	<table class="table table-responsive">
		<thead>
			<tr>
				<th></th>
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
					<td><img src="${images}/product/${product.productId}.png"
						class="img-rounded" alt="No Image Available" width="150"
						height="150"></td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.unitPrice}</td>
					<td>${product.quantity}</td>
					<td><a
						href="${contextPath}/admin/viewProducts/edit/${product.productId}"
						class="btn btn-warning" role="button"><span
							class="glyphicon glyphicon-pencil"></span> Edit</a></td>
					<td><a
						href="${contextPath}/admin/viewProducts/delete/${product.productId}"
						class="btn btn-danger" role="button"><span
							class="glyphicon glyphicon-trash"></span> Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Product List -->

