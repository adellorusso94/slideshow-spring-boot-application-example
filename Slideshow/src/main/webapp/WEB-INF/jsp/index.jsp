<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slideshow</title>
</head>
<body style="background: url(/resources/images/metallo.jpg) no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;">
	<div class="form" align="center" style="position:fixed; margin: auto; width: 50%; top: 50%; left:50%; transform: translate(-50%, -50%); border-style: solid; background-color: silver; padding: 20px;">
		<h3>${message}</h3>
		<h4>Login</h4>
		<form action="/" method="post" onSubmit="return validaInvio()">
			<p>
				<input id="username" type="text" placeholder="username" name="username">
			</p>
			<p>
				<input id="password" type="password" placeholder="password" name="password">
			</p>
			<p>
				<input type="submit" class="button" value="Accedi">
			</p>
		</form>
		<form action="/registrazione" method="get">
			<p><input type="submit" value="Registrati"></p>
		</form>
	</div>
	<script type="text/javascript" src="/resources/js/index.js"></script>
</body>
</html>