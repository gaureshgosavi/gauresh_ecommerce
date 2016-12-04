<div class="container">
	<div class="row">

		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-success">
				<div class="panel-heading">Payment Method</div>
				<p>Please select your payment method...</p>
				<div class="panel-body">
					<ul class="nav nav-pills">
						<li class="active"><a data-toggle="pill" href="#home">Cash
								On Delivery</a></li>
						<li><a data-toggle="pill" href="#credit">Debit Card</a></li>
						<li><a data-toggle="pill" href="#debit">Credit Card</a></li>
						<li><a data-toggle="pill" href="#cod">Card On Delivery</a></li>
					</ul>

					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">
							<input type="submit" class="btn btn-default" value="@es$KF&z"
								size="30" disabled><br> <input type="text"
								value="Please write above string" size="30"><br> <input
								type="submit" name="_eventId_submitPaymentDetails"
								class="btn btn-success" value="Confirm Order"> <input
								type="submit" name="_eventId_cancel"
								class="btn btn-md btn-danger" value="Cancel">
						</div>
						<div id="credit" class="tab-pane fade">
							<div class="jumbotron">
								<form id="credit-Details" role="form-horizontal">
									<div class="form-group">
										<input type="text" name="cardNo" id="cardNo"
											class="form-control" placeholder="Card Number" required />
									</div>
									<div class="form-group">
										<div class="col-md-6">
											<input type="number" name="pin" id="pin" class="form-control"
												placeholder="PIN" required />
										</div>
										<div class="col-md-6">
											<input type="submit" class="btn btn-default" value="CVV"
												size="5" disabled>
										</div>
									</div>
									<div class="form-group">

										<input type="text" class="" name="name" id="name"
											placeholder="Name on Card" required="true" />

									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="_eventId_submitPaymentDetails"
													class="btn btn-primary" value="Confirm Order"><input
													type="submit" name="_eventId_cancel"
													class="btn btn-md btn-danger" value="Cancel">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div id="debit" class="tab-pane fade">
							<div class="jumbotron">
								<form id="debit-Details" role="form-horizontal">
									<div class="form-group">
										<input type="text" name="ifscNo" id="ifscNo"
											class="form-control" placeholder="IFSCode" required="true" />
									</div>
									<div class="form-group">

										<input type="text" name="accNo" id="accNo"
											class="form-control" placeholder="Account Number"
											required="true" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="_eventId_submitPaymentDetails"
													class="btn btn-success" value="Confirm Order"><input
													type="submit" name="_eventId_cancel"
													class="btn btn-md btn-danger" value="Cancel">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div id="cod" class="tab-pane fade">
							<input type="submit" class="btn btn-default" value="@es$KF&z"
								size="30" disabled><br> <input type="text"
								value="Please write above string" size="30"><br> <input
								type="submit" name="_eventId_submitPaymentDetails"
								class="btn btn-success" value="submitPaymentDetails"> <input
								type="submit" name="_eventId_cancel"
								class="btn btn-md btn-danger" value="Cancel">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>