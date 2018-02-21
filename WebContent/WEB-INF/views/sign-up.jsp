<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Sign Up</title>
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

<!-- Custom Css -->
<link href='<c:url value="res/css/style.css"/>' rel="stylesheet">
</head>

<body class="signup-page">
	<div class="signup-box">
		<div class="logo">
			<a href="javascript:void(0);">Appointment<b>Taker</b></a> <small>it's
				a social media for taking appointment</small>
		</div>
		<div class="card">
			<div class="body">
				<form id="sign_up" method="POST" action="registration"
					modelAttribute="user">

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="msg">Sign Up</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">person</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="name"
								placeholder="Full Name" required autofocus>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">email</i>
						</span>
						<div class="form-line">
							<input type="email" class="form-control" name="email"
								placeholder="Email Address" required>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">D</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="dept"
								placeholder="Department" required autofocus>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">work</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="occupation"
								placeholder="Occupation" required autofocus>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">access_time</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="session"
								placeholder="Session" required autofocus>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">U</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="institute"
								placeholder="institute" required autofocus>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">lock</i>
						</span>
						<div class="form-line">
							<input type="password" class="form-control" name="password"
								minlength="6" placeholder="Password" required>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">lock</i>
						</span>
						<div class="form-line">
							<input type="password" class="form-control"
								name="passwordconfirm" minlength="6"
								placeholder="Confirm Password" required>
						</div>
					</div>
					<button class="btn btn-block btn-lg bg-pink waves-effect"
						type="submit">SIGN UP</button>

					<div class="m-t-25 m-b--5 align-center">
						<a href="sign-in">Already signUp?</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Jquery Core Js -->
	<script src='<c:url value="res/plugins/jquery/jquery.min.js"/>'></script>

	<!-- Bootstrap Core Js -->
	<script src='<c:url value="res/plugins/bootstrap/js/bootstrap.js"/>'></script>
	<!-- 	<script src="plugins/bootstrap/js/bootstrap.js"></script> -->

	<!-- Waves Effect Plugin Js -->
	<script src='<c:url value="res/plugins/node-waves/waves.js"/>'></script>
	<!-- <script src="plugins/node-waves/waves.js"></script> -->

	<!-- Validation Plugin Js -->
	<script
		src='<c:url value="res/plugins/jquery-validation/jquery.validate.js"/>'></script>
	<!-- <script src="plugins/jquery-validation/jquery.validate.js"></script> -->

	<!-- Custom Js -->
	<script src='<c:url value="res/js/admin.js"/>'></script>
	<!-- <script src="js/admin.js"></script> -->
	<script src='<c:url value="res/js/pages/examples/sign-up.js"/>'></script>
	<!-- <script src="js/pages/examples/sign-up.js"></script> -->
</body>

</html>