function validaInvio() {

	if (document.reg.cognome.value=="") {
		alert("Inserire cognome");
		return false;
	}
	if (document.reg.username.value=="" && document.getElementById('yesCheck').checked) {
		alert("Inserire username");
		return false;
	}
	if (document.reg.nome.value=="") {
		alert("Inserire nome");
		return false;
	}
	if (document.reg.data_nascita.value=="") {
		alert("Inserire data nascita");
		return false;
	}
	if (document.reg.password.value=="" && document.getElementById('yesCheck1').checked) {
		alert("Inserire password");
		return false;
	}
	return confirm('Modificare il profilo?');
}
function status() {
	alert("Modifica Effettuata, Effettua di nuovo il login");
	window.location = '/logout';
}
function yesnoCheck() {
    if (document.getElementById('yesCheck').checked) {
        document.getElementById('ifYes').style.display = 'block';
    }else if(document.getElementById('noCheck').checked) {
        document.getElementById('ifYes').style.display = 'none';
   }
}
function yesnoCheck1() {
    if (document.getElementById('yesCheck1').checked) {
        document.getElementById('ifYes1').style.display = 'block';
    }else if(document.getElementById('noCheck1').checked) {
        document.getElementById('ifYes1').style.display = 'none';
   }
}