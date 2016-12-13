<div class="container">
	<div class="row">
		<c:if test="${!empty msg}">
			<div class="alert alert-default" id="errorMessage">
				<strong>${msg}</strong>
			</div>
		</c:if>
	</div>
	<div class="row">
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
						<td><h3>${product.name}</h3> <br>&#8377; ${product.unitPrice}</td>
						<!--  <td><input type="submit" href="${contextPath}/product/productDetail/${productId}" class="btn btn-success"
							value="View Product" size="30"></td> -->
						<td><a
							href="${contextPath}/product/productDetail/${product.productId}"
							class="btn btn-success" role="button">View Product</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div> 
<!--  <div class="container">
	<c:forEach items="${productList}" var="product">
		<div class="col-md-3 col-sm-6">
			<div class="responsive">
				<div class="img">
					<a target="_blank" href="${contextPath}/product/productDetail/${product.productId}"> <img
						src="${images}/product/${product.productId}.png" alt="Forest" width="600" height="400">
					</a>
					<div class="desc"><h3 align="center">${product.name}</h3><p align="center">${product.unitPrice}</p></div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>-->