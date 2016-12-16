
<div class="container">
	<c:if test="${!empty errorMessage}">
		<div class="alert alert-danger" id="errorMessage">
			<strong>${errorMessage}</strong>
		</div>
	</c:if>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">LogIn</div>
				<div class="panel-body">
					<form action="${contextPath}/login" id="login-form" method="post"
						role="form-vertical">
						<div class="form-group">
							<label for="username">Username/Email</label> <input type="text"
								name="username" id="username" class="form-control"
								placeholder="Username" required="true" />
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								name="password" id="password" class="form-control"
								placeholder="Password" required="true" />
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-6 col-sm-offset-3">
									<button type="submit" class="form-control btn btn-primary"
										id="login-submit" name="submit">Login</button>
								</div>
							</div>
						</div>
						<div class="form-group text-right">
							<p>
								Don't have account?<a href="${contextPath}/register"
									class="btn btn-link" role="button">Sign Up here.</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>