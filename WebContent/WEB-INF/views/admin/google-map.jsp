<jsp:include page="layout/header.jsp" />

<jsp:include page="layout/nav-bar.jsp" />

<div id="wrapper">
	<!-- Navigation -->
	<jsp:include page="layout/nav-bar.jsp" />



	<!-- main container -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12"></div>


				<form action="google-map?30000" method="post" id="hello">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <input type="hidden" name="longitude"
						id="longitude" /> <input type="hidden" name="latitude"
						id="latitude" />
				</form>


				<script type="text/javascript">
					window.onload = function() {

						function geoLocation() {
							if (navigator.geolocation) {
								navigator.geolocation
										.getCurrentPosition(showPosition);
							}
						}
						function showPosition(position) {
							console.log(position.coords.latitude + " "
									+ position.coords.longitude);
							
							var url=window.location.search;
							var value=url.substr(1,url.length);
							var WAIT_TIME=parseInt(value);
							if(isNaN(WAIT_TIME)){
								WAIT_TIME=0;
							}
							//console.log(WAIT_TIME);
							var firstTime = 0;
							setTimeout(
									function wait() {
										document.getElementById('longitude').value = position.coords.longitude;
										document.getElementById('latitude').value = position.coords.latitude;
										document.getElementById('hello')
												.submit();
										
									},WAIT_TIME);

						}
						geoLocation();
						//console.log("Hello " +position);

					}
				</script>

			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->
</div>




<jsp:include page="layout/footer.jsp" />