function validaInvio() {
	var validato = true;
	
	if (document.getElementById("username").value=="") {
		alert("Inserire username");
		validato = false;
	}
	
	if (document.getElementById("password").value=="") {
		alert("Inserire password");
		validato = false;
	}
	
	if (document.getElementById("nome").value=="") {
		alert("Inserire nome");
		validato = false;
	}
	
	if (document.getElementById("cognome").value=="") {
		alert("Inserire cognome");
		validato = false;
	}
	
	if (document.getElementById("roles").value=="") {
		alert("Selezionare Tipo Utente");
		validato = false;
	}
	
	if (validato == false) {
		return false;
	} else {
		return true;
	}
}
