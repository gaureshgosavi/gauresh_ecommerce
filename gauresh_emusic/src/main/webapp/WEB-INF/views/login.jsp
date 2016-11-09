<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-6">
							<a href="#" class="active" id="login">Login</a>
						</div>
						<div class="col-xs-6">
							<a href="#" id="register">Register</a>
						</div>
					</div>
					<hr>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form id="login-form" method="post" role="form-vertical">
								<div class="form-group">
									<label for="username">User Name</label> <input type="text"
										name="username" id="username" class="form-control"
										placeholder="Username">
								</div>
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										name="password" id="password" class="form-control"
										placeholder="Password">
								</div>
								<div class="form-group text-center">
									<input type="checkbox" class="" name="remember" id="remember">
									<label for="remember">Keep me logged in</label>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<button type="submit" class="form-control btn btn-primary"
												id="login-submit" name="submit">Submit</button>
										</div>
									</div>
								</div>
							</form>
							<form id="register-form" method="post" role="form-vertical">
								<div class="form-group">
									<label for="username">User Name</label> <input type="text"
										name="username" id="username" class="form-control"
										placeholder="Username">
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="email"
										name="email" id="email" class="form-control"
										placeholder="Email Address">
								</div>
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										name="password" id="password" class="form-control"
										placeholder="Password">
								</div>
								<div class="form-group">
									<label for="confirm-password">Confirm Password</label> <input
										type="password" name="confirm-password" id="confirm-password"
										class="form-control" placeholder="Confirm Password">
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<button type="submit" name="submit" id="register-submit"
												class="form-control btn btn-primary">Submit</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
