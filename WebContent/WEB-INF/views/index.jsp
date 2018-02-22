<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<title>Home page of AppointmentTaker</title>
<!-- Favicon-->
<link rel="icon" href='<c:url value="res/favicon.ico"/>'
	type="image/x-icon">
<!-- Google Fonts -->
<link
	href='<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"/>'
	rel="stylesheet" type="text/css">
<link
	href='<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons"/>'
	rel="stylesheet" type="text/css">
<!-- Bootstrap Core Css -->
<link href='<c:url value="res/plugins/bootstrap/css/bootstrap.css"/>'
	rel="stylesheet">
<!-- Waves Effect Css -->
<link href='<c:url value="res/plugins/node-waves/waves.css"/>'
	rel="stylesheet" />
<!-- Animation Css -->
<link href='<c:url value="res/plugins/animate-css/animate.css"/>'
	rel="stylesheet" />
<!-- Morris Chart Css-->
<link href='<c:url value="res/plugins/morrisjs/morris.css"/>'
	rel="stylesheet" />
<!-- Custom Css -->
<link href='<c:url value="res/css/style.css"/>' rel="stylesheet">
<!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
<link href='<c:url value="res/css/themes/all-themes.css"/>'
	rel="stylesheet" />

</head>

<body class="theme-red">


	<!-- Google Map continues Location Passing -->

	<form action="location?3000" method="post" id="location">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="hidden" name="longitude"
			id="longitude" /> <input type="hidden" name="latitude" id="latitude" />
	</form>

  
	<script type="text/javascript">
		window.onload = function() {

			function geoLocation() {
				if (navigator.geolocation) {
					navigator.geolocation.getCurrentPosition(showPosition);
				}
			}
			function showPosition(position) {
				console.log(position.coords.latitude + " "
						+ position.coords.longitude);

				var url = window.location.search;
				console.log(url);
				var value = url.substr(1, url.length);
				console.log(value);
				//var v=${user.name};
				//console.log(v);
				var WAIT_TIME =500000;//parseInt(value);
				if (isNaN(WAIT_TIME)) {
					WAIT_TIME = 2500;
				}
				//console.log(WAIT_TIME);
				var firstTime = 0;
				setTimeout(
						function wait() {
							document.getElementById('longitude').value = position.coords.longitude;
							document.getElementById('latitude').value = position.coords.latitude;
							document.getElementById('location').submit();

						}, WAIT_TIME);

			}
			geoLocation();
			//console.log("Hello " +position);

		}
	</script>


	<!-- Google Map Continues Loaction Passing END -->



	<!-- Page Loader -->
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="preloader">
				<div class="spinner-layer pl-red">
					<div class="circle-clipper left">
						<div class="circle"></div>
					</div>
					<div class="circle-clipper right">
						<div class="circle"></div>
					</div>
				</div>
			</div>
			<p>Please wait...</p>
		</div>
	</div>
	<!-- #END# Page Loader -->
	<!-- Overlay For Sidebars -->
	<div class="overlay"></div>
	<!-- #END# Overlay For Sidebars -->
	<!-- Search Bar -->
	<div class="search-bar">
		<div class="search-icon">
			<i class="material-icons">search</i>
		</div>
		<input type="text" placeholder="START TYPING...">
		<div class="close-search">
			<i class="material-icons">close</i>
		</div>
	</div>
	<!-- #END# Search Bar -->
	<!-- Top Bar -->
	<jsp:include page="layout/nav-bar.jsp" />
	<!-- #Top Bar -->
	<!-- left side bar -->
	<jsp:include page="layout/left-side-bar.jsp" />

	<section class="content"> <!-- -Posting content -->
	<div style="width: 70%; float: left;">

		<div class="card">
			<form method="post" modelAttribute="post"
				action="./pUpload?${_csrf.parameterName}=${_csrf.token}"
				enctype="multipart/form-data">

				<!-- <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> -->
				<input type="hidden" name="authorId" value="${user.id}"
					required="required" />
				<div class="form-group header">
					<label style="text-align: center;">Upload Post</label>
					<div class="form-line">
						<input type="text" class="form-control" placeholder="title"
							name="title" />
					</div>
					<!--  <input type="text" name="title"
            class="form-control"  required="required" value="${post.title}"  /> -->
				</div>

				<div class="form-group header" style="margin-top: -5%;">

					<div class="form-line">
						<textarea rows="4" class="form-control no-resize"
							placeholder="Please type what you want..." name="description"></textarea>
					</div>
					<!--  <p>For bold use || and For link use <></p>
        <textarea rows="14" cols="" name="description" class="form-control" required="required">${post.description} </textarea> -->
				</div>
				<div class="form-group header" style="margin-top: -5%;">
					<label>Upload File</label> <input type="file" name="fileLink"
						class="btn btn-primary" />
				</div>
				<div style="text-align: right; margin-right: 3%;">
					<button style="margin-bottom: 3%; margin-left: 3%;"
						class="waves-effect waves-light btn bg-blue"
						id="colorChangeButton" type="submit">Post</button>
				</div>

			</form>
		</div>
		<!-- giving post -->


		<!-- end posting content -->
		<!-- Uploaded post -->
		<c:forEach items="${views}" var="view">
			<div class="card">

				<!--- new add class -->
				<div class="header">
					<div style="float: left;">
						<a href="#"> <img class="media-object photo-profile"
							src="http://0.gravatar.com/avatar/38d618563e55e6082adf4c8f8c13f3e4?s=40&d=mm&r=g"
							width="40" height="40" alt="...">
						</a>
					</div>
					<div>
						<h2>
							<a href="#" class="anchor-username">${view.user.name}</a> <small>
								<a href="#" style="color: blue;">${view.post.date}</a>
							</small>
						</h2>
						<h5>${view.post.title}</h5>
					</div>
					<ul class="header-dropdown m-r--5">
						<li class="dropdown"><a href="javascript:void(0);"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-haspopup="true" aria-expanded="false"> <i
								class="material-icons">more_vert</i>
						</a>
							<ul class="dropdown-menu pull-right">
								<li><a href="jquery-datatable.html">Edit appointment
										list</a></li>
							</ul></li>
					</ul>
				</div>

				<div class="body">${view.post.description}</div>

				<div class="modal-footer ">

					<div class="">

						<button class="waves-effect waves-light btn"
							id="requestColorChange" style="float: left;">
							Request for Appointment <span class="badge">10+</span>
						</button>

						<!--   start  for request list    -->

						<div>
							<button type="button"
								class="waves-effect waves-light btn bg-blue"
								style="float: left; margin-left: 20px;" data-toggle="modal"
								data-target="#smallModal">Request list</button>
						</div>
						<div class="modal fade" id="smallModal" tabindex="-1"
							role="dialog">
							<div class="modal-dialog modal-sm" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title" id="smallModalLabel"
											style="color: blue; float: left;">Request list</h4>
									</div>
									<div class="modal-body">
										<ul class="list-group">
											<li class="list-group-item">
												<button type="button"
													class="btn btn-default btn-block waves-effect"
													data-toggle="tooltip" data-placement="right"
													title="CSE , 2013-14">hafsa akther samia</button>
											</li>
											<li class="list-group-item">
												<button type="button"
													class="btn btn-default btn-block waves-effect"
													data-toggle="tooltip" data-placement="right"
													title="CSE , 2013-14">jeb un nesa jamal jemi</button>
											</li>
											<li class="list-group-item">
												<button type="button"
													class="btn btn-default btn-block waves-effect"
													data-toggle="tooltip" data-placement="right"
													title="CSE , 2013-14">Nahar e zobaida papry</button>
											</li>

										</ul>

									</div>
									<div class="modal-footer">
										<!-- <button type="button" class="btn btn-link waves-effect">SAVE CHANGES</button> -->
										<button type="button"
											class="btn btn-link waves-effect bg-grey"
											data-dismiss="modal">CLOSE</button>
									</div>
								</div>
							</div>
						</div>

						<!--   start  for appointment  list  for student   -->
						<div>
							<button type="button"
								class="waves-effect waves-light btn bg-green"
								style="float: right" data-toggle="modal"
								data-target="#defaultModal">Appointment list</button>
						</div>
						<div class="modal fade" id="defaultModal" tabindex="-1"
							role="dialog">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title" id="defaultModalLabel"
											style="color: #4CAF50; text-align: center;">Appointment
											list</h4>
									</div>
									<div class="modal-body">
										<table class="table">
											<thead>
												<tr>
													<th scope="row">#</th>
													<td style="font-weight: bold;">Name</td>
													<td style="font-weight: bold;">Department</td>
													<td style="font-weight: bold;">Session</td>
													<td style="font-weight: bold;">Appointment time</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th scope="row">1</th>
													<td>jemi</td>
													<td>cse</td>
													<td>2013-14</td>
													<td>12-01-2014</td>
												</tr>
												<tr>
													<th scope="row">2</th>
													<td>jemi</td>
													<td>cse</td>
													<td>2013-14</td>
													<td>12-01-2014</td>
												</tr>
												<tr>
													<th scope="row">3</th>
													<td>jemi</td>
													<td>cse</td>
													<td>2013-14</td>
													<td>12-01-2014</td>
												</tr>

											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<!--  <button type="button" class="btn btn-link waves-effect">SAVE CHANGES</button> -->
										<button type="button"
											class="btn btn-link waves-effect bg-grey"
											data-dismiss="modal">CLOSE</button>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!--   end of appointment  list  for student -->

				</div>

			</div>
		</c:forEach>
		<!--Uploaded post -->
	</div>

	</div>
	<!-- posts --> <!-- end of middle content   --> <!-- start of right side  content   -->
	<div style="float: right; width: 27%">
		<div class="card" style="margin-bottom: 0%">
			<div class="header">
				<h2>
					sir <small> <b>lecturer, <br>Computer Sceince and
							Engineering,<br>SUST<br> <b></small>
				</h2>
			</div>
			<div class="body">

				<div style="float: left">
					<button class="waves-effect waves-light btn" id="colorChangeButton">Follow</button>
				</div>
				<div>
					<button class="waves-effect waves-light btn" id="colorChangeButton"
						style="margin-left: 10%;">Need Appointment</button>
				</div>
			</div>
		</div>
	</div>
	<!-- end of right side content   --> </section>


	<!-- Jquery Core Js -->
	<script src='<c:url value="res/plugins/jquery/jquery.min.js"/>'></script>
	<!-- Bootstrap Core Js -->
	<script src='<c:url value="res/plugins/bootstrap/js/bootstrap.js"/>'></script>
	<!-- Select Plugin Js -->
	<script
		src='<c:url value="res/plugins/bootstrap-select/js/bootstrap-select.js"/>'></script>
	<!-- Slimscroll Plugin Js -->
	<script
		src='<c:url value="res/plugins/jquery-slimscroll/jquery.slimscroll.js"/>'></script>
	<!-- Waves Effect Plugin Js -->
	<script src='<c:url value="res/plugins/node-waves/waves.js"/>'></script>

	<script src='<c:url value="res/plugins/morrisjs/morris.js"/>'></script>
	<!-- Custom Js -->
	<script src='<c:url value="res/js/pages/ui/modals.js"/>'></script>
	<script src='<c:url value="res/js/admin.js"/>'></script>
	<script src='<c:url value ="res/js/pages/index.js"/>'></script>
	<!-- Demo Js -->

	<script src='<c:url value="res/js/demo.js"/>'></script>


</body>
</html>