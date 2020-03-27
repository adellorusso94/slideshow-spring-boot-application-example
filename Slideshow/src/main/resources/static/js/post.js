function validaInvio() {
	var validato = true;
	var fileInput = document.getElementById('immagine');
	var filePath = fileInput.value;
	var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
	if (!allowedExtensions.exec(filePath)) {
		alert('Inserisci un file avente come estensione .jpeg/.jpg/.png/.gif');
		fileInput.value = '';
		validato = false;
	}

	if (document.getElementById("descrizione").value == "") {
		alert("Inserire una descrizione");
		validato = false;
	}

	if (validato == false) {
		return false;
	}

	if (confirm("Creare il post?")) {
		var d = new Date();
		var date = d.getDate();
		var month = ("0" + (d.getMonth() + 1)).slice(-2);
		var year = d.getFullYear();
		var hour = ("0" + d.getHours()).slice(-2);
		var minute = ("0" + d.getMinutes()).slice(-2);
		var second = d.getSeconds();
		area = document.getElementById("data");
		area.value = date + "-" + month + "-" + year + " " + hour + ":"
				+ minute + ":" + second;
		return true;
	} else {
		return false;
	}
}

var elements = document.getElementsByClassName("dataPost");
for (var i = 0; i < elements.length; i++) {
	var data = new Date(elements[i].innerHTML);
	var giorno = data.getDate();
	var mese = ("0" + (data.getMonth() + 1)).slice(-2);
	var anno = data.getFullYear();
	var ora = ("0" + data.getHours()).slice(-2);
	var minuto = ("0" + data.getMinutes()).slice(-2);
	var secondo = ("0" + data.getSeconds()).slice(-2);
	elements[i].innerHTML = giorno + "-" + mese + "-" + anno + " " + ora + ":"
			+ minuto + ":" + secondo;
}