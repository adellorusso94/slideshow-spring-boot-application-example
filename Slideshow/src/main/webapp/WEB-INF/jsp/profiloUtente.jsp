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
<body
	style="background: url(/resources/images/metallo.jpg) no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;">
	<div align="center">
	<form action="/home" method="get">
		<input type="submit" value="Home">
	</form>
	</div>
	<br>
	<div align="center"
		style="margin: auto; width: 70%; border-style: solid; background-color: whitesmoke;">
		<p class="container"
			style="background-color: silver; margin-top: 0; margin-bottom: 0;"><b>Username:</b> ${utente.getUsername()}</p>
		<p class="container">
			<b>Nome:</b> ${utente.getNome()}
		</p>
		<p class="container">
			<b>Cognome:</b> ${utente.getCognome()}
		</p>
		<p class="container">
			<b>Data di nascita:</b>
			${utente.getData_nascita().toString().substring(0, 10)}
		</p>
		<c:if test="${idUtente == utente.getId_utente()}">
			<form action="/profili/${utente.getId_utente()}/modifica"
				method="get">
				<p class="container">
					<input type="submit" value="Modifica Profilo">
				</p>
			</form>
		</c:if>
	</div>
	<br>
	<div align="center">
		<c:forEach var="post" items="${utente.getPost()}">
			<div align="center"
				style="margin: auto; width: 70%; border-style: solid; background-color: whitesmoke;">
				<p
					style="background-color: silver; margin-top: 0; margin-bottom: 0;">@${utente.getUsername()}</p>
				<p style="margin-top: 0; margin-bottom: -4px;">
					<a href="/home/post/${post.getId_post()}"><img
						style="max-width: 100%; height: auto;"
						src="/home/post/${post.getId_post()}/immagine" /></a>
				</p>
				<p class="descrPost" style="margin-top: 0; margin-bottom: 0;">
					${post.getDescrizione()}</p>
				<p class="dataPost" style="margin-top: 0; margin-bottom: 0; background-color: silver;">
					${post.getData()}</p>
			</div>
			<br>
		</c:forEach>
	</div>
</body>
</html>