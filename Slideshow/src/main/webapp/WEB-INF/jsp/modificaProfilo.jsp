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
<c:if test="${res!=null}">
	<body onload="status()">
</c:if>
<body style="background: url(/resources/images/metallo.jpg) no-repeat center center fixed; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;">
	<div align="center" style="position:fixed; margin: auto; width: 50%; top: 50%; left:50%; transform: translate(-50%, -50%); border-style: solid; background-color: silver; padding: 20px;">
		<h3>${message}</h3>
		<h4>Modifica Profilo</h4>
		<form action="/profili/${idUtente}/modifica" name="reg" method="post"
			onSubmit="return validaInvio();">
			<p>
				Modificare username? no<input type="radio"
					onclick="javascript:yesnoCheck();" name="yesno" id="noCheck"
					checked /> si<input type="radio" onclick="javascript:yesnoCheck();"
					name="yesno" id="yesCheck" />
			</p>
			<div id="ifYes" style="display: none">
				<p>
					<input name="username" type="text" placeholder="nuovo username">
				</p>
			</div>
			<p>
				Modificare password? no<input type="radio"
					onclick="javascript:yesnoCheck1();" name="yesno1" id="noCheck1"
					checked /> si<input type="radio"
					onclick="javascript:yesnoCheck1();" name="yesno1" id="yesCheck1" />
			</p>
			<div id="ifYes1" style="display: none">
				<p>
					<input name="password" type="password" placeholder="nuova password">
				</p>
			</div>
			<p>
				<input name="nome" type="text" placeholder="nuovo nome">
			</p>
			<p>
				<input name="cognome" type="text" placeholder="nuovo cognome">
			</p>
			<p>
				<input name="data_nascita" type="text"
					placeholder="data nascita: dd-mm-yyyy">
			</p>
			<p>
				<input type="submit" value="Invio">
			</p>
		</form>
		<form action="/profili/${idUtente}/" method="get">
			<input type="submit" value="Profilo">
		</form>
	</div>
	<script type="text/javascript" src="/resources/js/modificaProfilo.js"></script>
</body>
</html>