<%-- 
<div class="container">
	<header class="row navbar-wrapper">
		<nav
			class="navbar navbar-inverse navbar-static-top col-md-8 offset-md-2">

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
	</header>
</div>
--%>

<div class="container-fluid">
	<div id="the-slider" class="carousel slide" data-ride="carousel">

		<ol class="carousel-indicators">
			<li data-target="#the-slider" data-slide-to="0" class="active"></li>
			<li data-target="#the-slider" data-slide-to="1"></li>
			<li data-target="#the-slider" data-slide-to="2"></li>
		</ol>

		<div class="carousel-inner" role="listbox">

			<div class="item active">
				<img class="First slide" alt="First slide"
					src="${images}/drumkit.jpg">
			</div>
			<!-- item 1-->

			<div class="item">
				<img class="Second slide" alt="Second slide"
					src="${images}/guitar.jpg">
			</div>
			<!-- item 2-->

			<div class="item">
				<img class="Third slide" alt="Third slide"
					src="${images}/keyboard.jpg">
			</div>
			<!-- item 3-->

		</div>
		<!-- carousel-inner -->

		<!-- controls -->
		<a class="left carousel-control" href="#the-slider" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#the-slider" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>

	</div>
	<!-- the slider -->


	<!-- /.container -->
	<hr>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<img class="image-square" alt="image" src="" width="170px"
					height="170px">
				<h2>Keyboard</h2>
				<p>This is keyboard</p>
			</div>

			<div class="col-lg-3">
				<img class="image-square" alt="image" src="" width="170px"
					height="170px">
				<h2>Guitar</h2>
				<p>This is Guitar</p>
			</div>

			<div class="col-lg-3">
				<img class="image-square" alt="image" src="" width="170px"
					height="170px">
				<h2>Drums</h2>
				<p>This is Drums</p>
			</div>

			<div class="col-lg-3">
				<img class="image-square" alt="image" src="" width="170px"
					height="170px">
				<h2>Flute</h2>
				<p>This is Flute</p>
			</div>

		</div>
	</div>

</div>