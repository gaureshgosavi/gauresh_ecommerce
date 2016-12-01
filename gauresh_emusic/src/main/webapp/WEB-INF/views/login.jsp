
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">LogIn</div>
				<div class="panel-body">
					<form action="${contextPath}/login" id="login-form" method="post"
						role="form-vertical">
						<div class="form-group">
							<label for="username">User Name</label> <input type="text"
								name="username" id="username" class="form-control"
								placeholder="Username" required="true" />
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								name="password" id="password" class="form-control"
								placeholder="Password" required="true" />
						</div>
						<div class="form-group text-center">
							<input type="checkbox" class="" name="remember" id="remember">
							<label for="remember">Keep me logged in</label>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-6 col-sm-offset-3">
									<button type="submit" class="form-control btn btn-success"
										id="login-submit" name="submit">Login</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>