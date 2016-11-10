
<div class="container">
	<div class="col-md-6">
		<fieldset>
			<legend>Login</legend>
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
		</fieldset>
	</div>

	<div class="col-md-6 offset-md-6">
		<fieldset>
			<legend>Register</legend>
			<form id="register-form" method="post" role="form-vertical">
				<div class="form-group">
					<label for="username">User Name</label> <input type="text"
						name="username" id="username" class="form-control"
						placeholder="Username">
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="email" name="email"
						id="email" class="form-control" placeholder="Email Address">
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
		</fieldset>
	</div>
</div>