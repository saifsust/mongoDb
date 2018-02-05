<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Login Page</title>

<link href='<c:url value="res/admin/css/bootstrap.min.css" />'
	rel="stylesheet">
<link href='<c:url value="res/admin/css/bootstrap.css" />'
	rel="stylesheet">

<!-- Custom Fonts -->

<link
	href='<c:url value="res/admin/font-awesome/css/font-awesome.min.css" />'
	rel="stylesheet">
</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>
	<form name='f' action='/javawebdevelopment/login' method='POST'>


		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<div class="form-group">
			<input type='text' name='username' value='' class="input-xlarge">
		</div>

		<div class="form-group">
			<input type='password' name='password' />
		</div>



		<input name="submit" type="submit" value="Login"
			class="btn btn-primary" />



		<!-- hidden field -->
		<!-- 	<input name="_csrf" type="hidden"
			value="8943b6cf-5b6a-4fcc-9cd1-b94ecfb00b6c" />
 -->
		<!--  
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />-->
	</form>
</body>
</html>