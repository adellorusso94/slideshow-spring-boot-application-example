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
	<div align="center" style="width: auto;">
		<form action="/profili/${idUtente}" method="get">
			<input type="submit" value="Profilo">
		</form>
		<br>
		<form action="/logout" method="get">
			<input type="submit" value="Logout">
		</form>
	</div>
	<br>
	<div align="center" style="margin: auto; width: 70%; border-style: solid; background-color: whitesmoke;">
		<form action="/home/post/crea" name="creaPost" method="post"
			enctype="multipart/form-data" onsubmit="return validaInvio();">
			<input type="hidden" id="id_utente" name="id_utente"
				value="${id_utente}"> <input type="hidden" id="data"
				name="data" value="">
			<p style="background-color: silver; margin-top: 0;">
				<b>Carica immagine:</b>
			</p>
			<p>
				<input type="file" id="immagine" name="immagine">
			</p>
			<p style="background-color: silver;">
				<b>Scrivi una descrizione:</b>
			</p>
			<p>
				<textarea style="resize: none;" id="descrizione" name="descrizione"
					rows="6" cols="40" maxlength="200"></textarea>
			</p>
			<p>
				<input type="submit" value="Posta">
			</p>
		</form>
	</div>
	<br>
	<div align="center">
		<c:forEach var="post" items="${lista_post}">
			<div style="margin: auto; width: 70%; border-style: solid; background-color: whitesmoke;">
				<div
					style="background-color: silver; margin-top: 0; margin-bottom: 0;">
						<form method="get" action="/profili/${post.getAutore().getId_utente()}">
  			  			<a href="/profili/${post.getAutore().getId_utente()}">@${post.getAutore().getUsername()}</a>
						</form>
				</div>
				<p style="margin-top: 0; margin-bottom: -4px;">
					<a href="/home/post/${post.getId_post()}"><img
						style="max-width: 100%; height: auto;"
						src="/home/post/${post.getId_post()}/immagine" /></a>
				</p>
				<p style="margin-top: 0; margin-bottom: 0;">
					<i>${post.getDescrizione()}</i>
				</p>
				<p class="dataPost"
					style="background-color: silver; margin-top: 0; margin-bottom: 0;">
					${post.getData()}</p>
			</div>
			<br>
		</c:forEach>
	</div>
	<script type="text/javascript" src="/resources/js/post.js"></script>
</body>
</html>