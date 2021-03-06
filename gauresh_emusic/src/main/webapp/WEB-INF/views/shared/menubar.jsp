

<%-- 
<header class="row">
	<div>
		<a href="#"><img src="${images}/logo.jpg" alt="" width="100%"
			height="100px"></a>
	</div>
	<nav class="navbar navbar-inverse">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextPath}/index">Emu$ic</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${contextPath}/index">Home</a></li>
				<li><a href="${contextPath}/products">Products</a></li>
				<li><a href="${contextPath}/about">About us</a></li>
				<li><a href="${contextPath}/contact">Contact us</a></li>
				<li><a href="${contextPath}/admin">Admin</a></li>
				<li><a href="${contextPath}/login">Login</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->

	</nav>
</header> --%>
<div class="navbar-wrapper">
	<div class="container">

		<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${contextPath}/index"> <span
						class="glyphicon glyphicon-home"></span> Emu$ic
					</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${contextPath}/index">Home</a></li>
						<li><a href="${contextPath}/product">Products</a></li>
						<li><a href="${contextPath}/about">About us</a></li>
						<li><a href="${contextPath}/contact">Contact us</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<form action="" class="search-form">
								<div class="form-group has-feedback">
									<label for="search" class="sr-only">Search</label> <input
										type="text" class="form-control" name="search" id="search"
										placeholder="search"> <span
										class="glyphicon glyphicon-search form-control-feedback"></span>
								</div>
							</form>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"><span
								class="glyphicon glyphicon-hand-down"></span> Admin</a>
							<ul class="dropdown-menu">
								<li><a href="${contextPath}/admin/viewProducts">View
										Products</a></li>
								<li><a href="${contextPath}/admin/viewCategories">View
										Categories</a></li>
								<li><a href="${contextPath}/admin/viewSuppliers">View
										Suppliers</a></li>
							</ul></li>
						<li><a href="${contextPath}/login"> <span
								class="glyphicon glyphicon-cog"></span> Settings
						</a></li>
					</ul>
				</div>
			</div>
		</nav>

	</div>
</div>
