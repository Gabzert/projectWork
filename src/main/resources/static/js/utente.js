let url = "http://localhost:8080/api/prenotazioni";



async function loadUtente() {

	let response = await fetch('http://localhost:8080/api/utenti/utente');
	let utenti = await response.json();

	const context = {
		'utente': utenti
	};

	handle("template_swiper2", "output-div2", context);
}

function handle(idTemplate, idOutput, context) {

	let templateScript = document.getElementById(idTemplate).innerHTML;

	// handlebar
	let template = Handlebars.compile(templateScript);
	let htmlCompilato = template(context);

	let output = document.getElementById(idOutput);
	output.innerHTML = htmlCompilato;

}


function editPrenotazione(event) {

	let originator = event.currentTarget;
	let prenotazione_id = originator.getAttribute('data-prenotazione-id');
	let slot_veicolo = document.getElementById("modello_" + prenotazione_id);
	let slot_data = document.getElementById("titolo_" + prenotazione_id);
	let prenotazione_veicolo = slot_veicolo.innerHTML;
	let prenotazione_data = slot_data.innerHTML;

	let salva = document.getElementById("bottone_salva_" + prenotazione_id);

	salva.removeAttribute("hidden");

	let dd = document.createElement('select');
	dd.className="form-select form-select-lg mb-3";
	dd.id = "dropdownVeicoli"
	slot_veicolo.replaceWith(dd);


	fetch("http://localhost:8080/api/veicoli")
		.then(function (response) {
			return response.json();
		})
		.then(function (json) {
			for (let li = 0; li < json.length; li++) {
				if (json[li].status == "disponibile") {
					let opzione = document.createElement("option");
					opzione.text = json[li].modello;
					dd.appendChild(opzione);
				}
			}
		})
		.then(function () {

			for (let i = 0; i < dd.options.length; i++) {
				if (dd.options[i].text === prenotazione_veicolo) {
					dd.selectedIndex = i;
					break;
				}
			}

			let data_select = document.createElement("input");
			data_select.setAttribute("type", "date");
			data_select.className="form-control form-control-lg my-3 mx-3";
			slot_data.replaceWith(data_select);

			
			const utcDate = moment(prenotazione_data, 'DD-MM-YYYY')
			const localDate = moment(utcDate).format('YYYY-MM-DD');

			console.log(prenotazione_data);
			data_select.value = localDate;
		})

}




function salvaModifiche(event) {
	let originator = event.currentTarget;

	fetch(url + "/editPrenotazione", {
		method: 'POST',
		body: JSON.stringify({
			"id": id,
			"new_data": new_data,
			"new_veicolo": new_veicolo,
			"utente_id": utente_id
		}),
		headers: {
			'Content-type': 'application/json; charset=UTF-8'
		}
	})
		.then(response => response.json())
		.then(json => {
			console.log(json);
		});

	refreshPrenotazioni();


}

function deletePrenotazione(event) {
	let originator = event.currentTarget;
	let id = originator.getAttribute('data-prenotazione-id');


	if (confirm("Sei sicuro di voler cancellare la prenotazione: " + id)) {
		fetch(url + "/?id=" + encodeURIComponent(id)

		)
			.then(function (response) {
				return response.json();
			})
			.then(function (json) {

				console.log(json);

				if (json.result !== 0) {
					alert("Error " + json.result + " in deleteThought: " + json.message);
				}
				refreshPrenotazioni();

			})
			.catch(function (err) {
				alert(err);
				console.log('Failed to fetch page: ', err);
			});
	}
}

function refreshPrenotazioni(event) {

let lista1 =[]
let lista2 =[]
let context_incorso={};
let context_terminate={};

	fetch(url)
		.then(function (response) {

			return response.json();

		})
		.then(function (json) {
			console.log(json);

			lista_prenotazioni = json;

			
			

			for (let li = 0; li < lista_prenotazioni.length; li++) {
				if (lista_prenotazioni[li].status == "in prenotazione") {
					lista1.push(lista_prenotazioni[li])
				} else {
					lista2.push(lista_prenotazioni[li])
				}
				
			}
			context_incorso = {"prenotazioni":lista1}
			context_terminate = {"prenotazioni":lista2}

			handle("template_attuale", "div_attuale", context_incorso)
			handle("template_old", "div_old", context_terminate)

			agganciaEventi();
		})
		.catch(function (err) {
			alert(err);
			console.log('Failed to fetch page: ', err);
		});
}

function agganciaEventi(event) {
	let btn_modifica = document.getElementsByClassName("bottone_modifica");
	for (let li = 0; li < btn_modifica.length; li++) {
		btn_modifica[li].addEventListener("click", editPrenotazione);
	}

	let btn_cancella = document.getElementsByClassName("bottone_cancella");
	for (let li = 0; li < btn_cancella.length; li++) {
		btn_cancella[li].addEventListener("click", deletePrenotazione);
	}

	let btn_salva = document.getElementsByClassName("bottone_salva");
	for (let li = 0; li < btn_salva.length; li++) {
		btn_salva[li].addEventListener("click", salvaModifiche);
	}
}

Handlebars.registerHelper('dateFormat', function (date, options) {
    const formatToUse = (arguments[1] && arguments[1].hash && arguments[1].hash.format) || "DD/MM/YYYY"
    return moment(date).format(formatToUse);
});

window.addEventListener(
	'DOMContentLoaded',
	function (event) {
	
		loadUtente;
		refreshPrenotazioni(null);
	});