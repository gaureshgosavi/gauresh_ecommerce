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
			<li data-target="#the-slider" data-slide-to="3"></li>
		</ol>

		<div class="carousel-inner" role="listbox">

			<div class="item active">
				<img class="First slide" alt="First slide" src="${images}/drums.jpg">
				<div class="carousel-caption">
					<h1>Bounce to the BOOM of the beat of the drum</h1>
				</div>
			</div>

			<!-- item 1-->

			<div class="item">
				<img class="Second slide" alt="Second slide"
					src="${images}/guitar.jpg">

				<div class="carousel-caption">
					<h1>Well i got this Guitar and I learned how to make it talk.</h1>
				</div>
			</div>
			<!-- item 2-->

			<div class="item">
				<img class="Third slide" alt="Third slide"
					src="${images}/keyboard.jpg">
				<div class="carousel-caption">
					<h1>You can't buy happiness but you can buy keyboard and
						that's kind of same thing.</h1>
				</div>
			</div>
			<!-- item 3-->

			<div class="item">
				<img class="Fourth slide" alt="Fourth slide" src="${images}/mic.jpg">

				<div class="carousel-caption">
					<h1>One good thing about music, when it hits, you feel no
						pain.</h1>
				</div>
			</div>
			<!-- item 4-->


			<!-- carousel-inner -->

			<!-- controls -->
			<a class="left carousel-control" href="#the-slider" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#the-slider" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</div>
<!-- the slider -->

<div class="container">
	<div class="jumbotron">
		<h2>"Without music, life would be a mistake"</h2>
		<h1>LET's GET MORE INTO MUSIC....</h1>
	</div>
</div>

<!-- /.container -->
<hr>
<div class="container">
	<h3>
		<Strong>LATEST PRODUCTS...</Strong>
	</h3>
	<br>
	<div class="row">

		<c:forEach items="${latestProduct}" var="product">
			<div class="col-md-3 col-sm-6 product">
				<img src="${images}/product/${product.productId}.png"
					class="img-square" alt="No Image Available" width="200px"
					height="200px"><br>
				<h4>${product.name}</h4>
				<p>
					<b>Price:</b> &#8377; ${product.unitPrice}
				</p>
				<a href="${contextPath}/product/productDetail/${product.productId}"
					class="btn btn-success" role="button">View Product</a>
			</div>
		</c:forEach>
	</div>
</div>
