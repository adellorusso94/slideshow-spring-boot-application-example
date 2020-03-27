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
		<form action="/home/post" method="get">
			<input type="submit" value="Home">
		</form>
	</div>
	<br>
	<div align="center" style="margin: auto; width: 70%; border-style: solid; background-color:whitesmoke">
		<p style="background-color: silver; margin-top: 0; margin-bottom: 0;">
			@${post.getAutore().getUsername()}</p>
		<p
			style="margin-top: 0; margin-bottom: 0">
			<img style="max-width: 100%; height: auto; margin-bottom: -4px;"
				src="/home/post/${post.getId_post()}/immagine" />
		</p>
		<p style="margin-top: 0; margin-bottom: 0;">
			<i>${post.getDescrizione()}</i>
		</p>
		<p class="dataPost"
			style="background-color: silver; margin-top: 0; margin-bottom: 0;">
			${post.getData()}</p>
	</div>
	<br>
	<c:choose>
		<c:when test="${post.getAutore().getId_utente() == id_utente}">
			<div align="center" style="margin: auto; width: 70%; border-style: solid; background-color:whitesmoke">
				<form action="/home/post/${post.getId_post()}/modifica"
					enctype="multipart/form-data" onsubmit="return validaModifica()"
					method="post">
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
						<textarea style="resize: none;" id="descrizione"
							name="descrizione" rows="6" cols="40" maxlength="200"></textarea>
					</p>
					<p>
						<input type="submit" value="Modifica">
					</p>
				</form>
				<form action="/home/post/${post.getId_post()}/cancella"
					onsubmit="return validaCancella()" method="get">
					<p><input type="submit" value="Cancella"></p>
				</form>
			</div>
			<br>
		</c:when>
		<c:when test="${admin == 'ROLE_ADMIN'}">
			<div align="center" style="width: auto; border-style: solid; background-color:whitesmoke">
				<form action="/home/post/${post.getId_post()}/cancella"
					onsubmit="return validaCancella()" method="get">
					<p><input type="submit" value="Cancella"></p>
				</form>
			</div>
			<br>
		</c:when>
	</c:choose>
	<div align="center">
		<div style="margin: auto; width: 70%; border-style: solid; background-color:whitesmoke">
			<form action="/home/post/${post.getId_post()}/commenti/crea"
				name="creaCommento" method="post" onsubmit="return validaInvio();">
				<input type="hidden" id="id_utente" name="id_utente"
					value="${id_utente}"> <input type="hidden" id="data"
					name="data" value="">
				<p style="background-color: silver; margin-top: 0;">
					<b>Scrivi un commento:</b>
				</p>
				<p>
					<textarea style="resize: none;" id="testo" name="testo" rows="6"
						cols="40" maxlength="200"></textarea>
				</p>
				<p>
					<input type="submit" value="Commenta">
				</p>
			</form>
		</div>
		<br>
		<c:forEach var="commento" items="${post.getCommenti()}">
			<div style="margin: auto; width: 70%; border-style: solid; background-color:whitesmoke">
				<p style="background-color: silver; margin-top: 0;">
					@${commento.getAutore().getUsername()}</p>
				<p>${commento.getTesto()}</p>
				<p class="dataPost"
					style="background-color: silver; margin-bottom: 0;">
					${commento.getData()}</p>
				<c:choose>
					<c:when test="${commento.getAutore().getId_utente() == id_utente}">
						<form
							action="/home/post/${commento.getPost().getId_post()}/commenti/${commento.getId_commento()}/modifica"
							onsubmit="return validaModificaCommento(document.getElementById('${commento.getId_commento()}').id)" method="post">
							<p style="background-color: silver; margin-top: 0;">
								<b>Scrivi un commento:</b>
							</p>
							<p>
								<textarea style="resize: none;" id="${commento.getId_commento()}" name="testo" rows="6"
									cols="40" maxlength="200"></textarea>
							</p>
							<p>
								<input type="submit" value="Modifica">
							</p>
						</form>
						<form
							action="/home/post/${commento.getPost().getId_post()}/commenti/${commento.getId_commento()}/cancella"
							onsubmit="return validaCancellaCommento()" method="get">
							<p><input type="submit" value="Cancella"></p>
						</form>
					</c:when>
					<c:when test="${admin == 'ROLE_ADMIN'}">
						<form
							action="/home/post/${commento.getPost().getId_post()}/commenti/${commento.getId_commento()}/cancella"
							onsubmit="return validaCancellaCommento()" method="get">
							<p><input type="submit" value="Cancella"></p>
						</form>
					</c:when>
				</c:choose>
			</div>
			<br>
		</c:forEach>
	</div>
	<script type="text/javascript" src="/resources/js/dettaglioPost.js"></script>
</body>
</html>