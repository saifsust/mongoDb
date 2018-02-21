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
<body class="login-page">
	<div class="login-box">
		<div class="logo">
			<a href="javascript:void(0);">Appointment<b>Taker</b></a> <small>it's
				a social media for taking appointment</small>
		</div>
		<div class="card">
			<div class="body">
				<form id="sign_in" method="POST" modelAttribute="signIn"
					action="verify">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="msg">Sign in</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">person</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="userName"
								placeholder="Email" required autofocus>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">lock</i>
						</span>
						<div class="form-line">
							<input type="password" class="form-control" name="password"
								placeholder="Password" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-8 p-t-5">
							<input type="checkbox" name="rememberme" id="rememberme"
								class="filled-in chk-col-pink"> <label for="rememberme">Remember
								Me</label>
						</div>
						<div class="col-xs-4">
							<button class="btn btn-block bg-pink waves-effect" type="submit">SIGN
								IN</button>
						</div>
					</div>
					<div class="row m-t-15 m-b--20">
						<div class="col-xs-6">
							<a href="sign-up">Register Now!</a>
						</div>
						<div class="col-xs-6 align-right">
							<a href="forgot-password.html">Forgot Password?</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Jquery Core Js -->
	<script src="plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script src="plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="plugins/node-waves/waves.js"></script>

	<!-- Validation Plugin Js -->
	<script src="plugins/jquery-validation/jquery.validate.js"></script>

	<!-- Custom Js -->
	<script src="js/admin.js"></script>
	<script src="js/pages/examples/sign-in.js"></script>
</body>

</html>