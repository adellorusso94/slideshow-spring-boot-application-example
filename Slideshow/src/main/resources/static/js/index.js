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
	
	if (validato == false) {
		return false;
	} else {
		return true;
	}
}