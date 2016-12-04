<div class="container">
	<div class="row">
		<c:if test="${!empty error}">
			<div class="alert alert-danger" id="messageDelete-success">
				<strong>${error}</strong>
			</div>
		</c:if>
	</div>
	<div class="row">

		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-success">


				<div class="panel-heading">Register</div>
				<div class="panel-body">


					<form:form method="post" action="${contextPath}/register"
						modelAttribute="user" cssClass="form-vertical">
						<div class="form-group">
							<label for="username">Email</label>
							<form:input path="username" type="email" id="username"
								cssClass="form-control" placeholder="Username" required="true" />
						</div>
						<form:input type="hidden" path="userId" />
						<div class="form-group">
							<label for="password">Password</label>
							<form:input path="password" type="password" id="password"
								cssClass="form-control" placeholder="Password" required="true" />
						</div>
						<div class="form-group">
							<label for="confirm-password">Confirm Password</label>
							<form:input path="confirmPassword" type="password"
								id="confirm-password" cssClass="form-control"
								placeholder="Confirm Password" required="true" />
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-6 col-sm-offset-3">
									<button type="submit" name="submit" id="register-submit"
										class="form-control btn btn-success">Register</button>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>