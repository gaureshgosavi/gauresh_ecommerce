<div class="container">
	<div class="row">

		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-info">
				<div class="panel-heading">Billing Address</div>
				<div class="panel-body">
					<form:form method="post"
						action="${contextPath}/user/billingAddress"
						cssClass="form-horizontal" modelAttribute="billingAddress">
						<div class="form-group">
							<label for="line1">Line 1</label>

							<form:input path="line1" type="text" id="line1"
								class="form-control" placeholder="Address Line 1"
								required="true" />

						</div>
						<div class="form-group">
							<label for="line2">Line 2</label>

							<form:input path="line2" type="text" cssClass="form-control"
								placeholder="Address Line 2" required="true" />

						</div>
						<div class="form-group">
							<label for="city">City</label>

							<form:input path="city" type="text" cssClass="form-control"
								placeholder="City" required="true" />

						</div>
						<div class="form-group">
							<label for="state">State</label>

							<form:input path="state" type="text" cssClass="form-control"
								placeholder="State" required="true" />
						</div>
				</div>
				<div class="form-group">
					<label for="country">Country</label>

					<form:input path="country" type="text" cssClass="form-control"
						placeholder="Country" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label for="zipCode">Zip code</label>

				<form:input path="zipCode" type="text" cssClass="form-control"
					placeholder="Zip code" required="true" />
			</div>
		</div>
		<div class="col-md-offset-3">
			<input type="submit" name="_eventId_submitBillingAddress"
				class="btn btn-md btn-success" value="Save">
			<form:form>
				<input type="submit" name="_eventId_cancel"
					class="btn btn-md btn-danger" value="Cancel">
			</form:form>
		</div>
		</form:form>
	</div>
</div>