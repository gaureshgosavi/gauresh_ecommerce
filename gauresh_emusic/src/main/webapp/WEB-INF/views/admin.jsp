<div class="container">
	<div class="container col-md-4">
		<fieldset>
			<legend>Add New Product</legend>
			<form class="form-vertical">
				<div class="form-group">
					<label for="name">Product name</label> <input type="text"
						class="form-control" id="name" placeholder="Name">
				</div>
				<div class="form-group">
					<label for="description">Description</label> <input type="text"
						class="form-control" id="description" placeholder="Description">
				</div>
				<div class="form-group">
					<label for="category">Category</label> <select class="form-control"
						id="category">
						<option>Category1</option>
						<option>Category2</option>
						<option>Category3</option>
					</select>
				</div>
				<div class="form-group">
					<label for="category">Supplier</label> <select class="form-control"
						id="category">
						<option>Supplier1</option>
						<option>Supplier2</option>
						<option>Supplier3</option>
					</select>
				</div>
				<div class="form-group">
					<label for="unit_price">Unit Price</label> <input type="number"
						class="form-control" id="unit_price" placeholder="unit price">
				</div>
				<div class="form-group">
					<label for="quantity">Quantity</label> <input type="number"
						class="form-control" id="quantity" placeholder="Quantity">
				</div>
				<div class="form-group">
					<label for="file">Upload File</label> <input type="file" id="file"
						class="form-control" placeholder="Upload file">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Add Product</button>
				</div>
			</form>
		</fieldset>
	</div>
	<!-- product form -->


	<div class="container col-md-4">
		<fieldset>
			<legend>Add New Category</legend>
			<form class="form-vertical">
				<div class="form-group">
					<label for="name">Category name</label> <input type="text"
						class="form-control" id="name" placeholder="Name">
				</div>
				<div class="form-group">
					<label for="description">Description</label> <input type="text"
						class="form-control" id="description" placeholder="Description">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Add Category</button>
				</div>
			</form>
		</fieldset>
	</div>
	<!-- category form -->


	<div class="container col-md-4">
		<fieldset>
			<legend>Add New Supplier</legend>
			<form class="form-vertical">
				<div class="form-group">
					<label for="name">Supplier name</label> <input type="text"
						class="form-control" id="name" placeholder="Name">
				</div>
				<div class="form-group">
					<label for="email">Email ID</label> <input type="email"
						class="form-control" id="email" placeholder="Email ID">
				</div>
				<div class="form-group">
					<label for="contact_no">Contact No</label> <input type="number"
						class="form-control" id="contact_no" placeholder="contact no">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Add Supplier</button>
				</div>
			</form>
		</fieldset>
	</div>
	<!-- Supplier -->
</div>