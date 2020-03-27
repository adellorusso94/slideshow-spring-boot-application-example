<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<h4>Registrazione</h4>
		<form action="/registrazione" method="post"
			onSubmit="return validaInvio()">
			<p>
				<input id="username" name="username" type="text"
					placeholder="username">
			</p>
			<p>
				<input id="password" name="password" type="password"
					placeholder="password">
			</p>
			<p>
				<input id="nome" name="nome" type="text" placeholder="nome">
			</p>
			<p>
				<input id="cognome" name="cognome" type="text" placeholder="cognome">
			</p>
			<p>
				<input id="data_nascita" name="data_nascita" type="text"
					placeholder="data nascita: dd-mm-yyyy">
			</p>
			<p>
				<select id="roles" name="roles">
					<option value="">Tipo Utente</option>
					<option value="ROLE_USER">User</option>
					<option value="ROLE_ADMIN">Admin</option>
				</select>
			</p>
			<p>
				<input type="submit" value="Registrati">
			</p>
		</form>
		<form action="/" method="get">
			<p>
				<input type="submit" value="Login">
			</p>
		</form>
	</div>
	<script type="text/javascript" src="/resources/js/registrazione.js"></script>
</body>
</html>