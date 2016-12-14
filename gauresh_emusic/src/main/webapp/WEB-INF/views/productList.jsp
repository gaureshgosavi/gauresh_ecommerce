<div class="container">
	<c:choose>
		<c:when test="${empty productList}">
			<h3 align="center">No products available in this category.</h3>
		</c:when>
		<c:otherwise>
			<div class="row">
				<c:if test="${!empty msg}">
					<div class="alert alert-default" id="errorMessage">
						<strong>${msg}</strong>
					</div>
				</c:if>
			</div>
			<!-- <div class="row">
				<table class="table table-hover">
					<thead>
						<tr>
							<th></th>
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
								<td><h3>${product.name}</h3> <br> <b>Price:</b>
									&#8377; ${product.unitPrice}</td>
								<!--  <td><input type="submit" href="${contextPath}/product/productDetail/${productId}" class="btn btn-success"
							value="View Product" size="30"></td> 
								<td><a
									href="${contextPath}/product/productDetail/${product.productId}"
									class="btn btn-success" role="button">View Product</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>  -->
			<div class="container">
				<c:forEach items="${productList}" var="product">
					<div class="col-md-3 col-sm-6">
						<img src="${images}/product/${product.productId}.png"
							class="img-rounded" alt="No Image Available" width="200"
							height="200"><br>
						<h3>${product.name}</h3>
						<p>
							<b>Price:</b> &#8377; ${product.unitPrice}
						</p>
						<a
							href="${contextPath}/product/productDetail/${product.productId}"
							class="btn btn-success" role="button">View Product</a>
					</div>
				</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>
</div>

