let url="http://localhost:8080/api/prenotazioni";

let template_old =null;
let template_incorso = null;
let p_old = null;
let p_incorso = null;
let hb_incorso = null;
let hb_old = null;

function loadUtente(){

	
	fetch(url)
			.then(function(response) {
				return response.json();
			})
			.then(function(json) {
				console.log(json);
				let righe = "";
				if(json.result !== 0){
					alert("Error "+json.result+" in prenotazioni: "+json.message);
				} else {
					let riga = document.getElementById("info_utente").innerHTML;
					righe += riga.replaceAll("{{id}}", json.data.utente.id)
						.replaceAll("{{Nome}}", json.data.utente.nome)
						.replaceAll("{{Cognome}}", json.data.utente.cognome)
						.replaceAll("{{Data di nascita}}", json.data.utente.data_nascita)
						.replaceAll("{{Email}}", json.data.utente.email);
					}
				document.getElementById("info_utente").innerHTML = righe;
				agganciaEventi();
			})
			.catch(function(err) { 
					alert(err);
					console.log('Failed to fetch page: ', err);
			});	
			


}


function editPrenotazione(event){
	let originator = event.currentTarget;
	let prenotazione_id = originator.getAttribute('data-prenotazione-id');
	let slot_veicolo =document.querySelector(".card-title[data-prenotazione-id="+prenotazione_id+"]") ;
	let slot_data = document.querySelector(".card-header[data-prenotazione-id="+prenotazione_id+"]") ;
	let prenotazione_veicolo = slot_veicolo.innerHTML;
	let prenotazione_data = slot_data.innerHTML;
	
		
		let dd = document.createElement('select');
		dd.id ="dropdownVeicoli"
		slot_veicolo.replaceWith(dd);
		fetch("http://localhost:8080/api/veicoli")
		.then(function(response) {
			return response.json();
		})
		.then(function(json) {
			for(let li=0; li<json.length; li++){
				if(json.data[li].status == "disponibile"){
				let opzione =document.createElement("option");
				opzione.text =json.data[li].modello;
				dd.appendChild(opzione);
				}
			}
		})
		for (let i = 0; i < dd.options.length; i++) {
		if (dd.options[i].text === prenotazione_veicolo) {
			dd.selectedIndex = i;
			break;
			}
		}	

		let data_select = document.createElement("input");
		data_select.setAttribute("type", "date");
		slot_data.replaceWith(data_select);
		data_select.value = prenotazione_data;
	
	}




function salvaModifiche(event){
	let originator = event.currentTarget;



	
/*	
	fetch(url+"/editPrenotazione", {
        method: 'POST',
        body: JSON.stringify(newPrenotazione),
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
    })
    .then(response => response.json())
    .then(json => {
        console.log(json);
    });
*/	
	refreshPrenotazioni();

	
}

function deletePrenotazione(event){
	let originator = event.currentTarget;
	let id = originator.getAttribute('data-prenotazione-id');
	

	if(confirm("Sei sicuro di voler cancellare la prenotazione: "+id)){
		fetch(url+"/?id="+encodeURIComponent(id)
		
		)
		.then(function(response) {
			return response.json();
		})
		.then(function(json) {
				
				console.log(json);

				if(json.result !== 0){
					alert("Error "+json.result+" in deleteThought: "+json.message);
				}
				refreshPrenotazioni();
				
		})
		.catch(function(err) { 
				alert(err);
				console.log('Failed to fetch page: ', err);
		});
	}
}

function refreshPrenotazioni(event){
let response ="";
let lista_prenotazioni="";
/*

response = fetch(url);
lista_prenotazioni =  response.json();

const context = {
	'prenotazioni': lista_prenotazioni
};
*/
			fetch(url)
			.then(function(response) {

				return response.json();
				
			})
			.then(function(json) {
				console.log(json);

				lista_prenotazioni= json;
				console.log(lista_prenotazioni);
				const context = {
					'prenotazioni': lista_prenotazioni
				};
				console.log(lista_prenotazioni);

				if(json.result !== 0){
					alert("Error "+json.result+" in prenotazioni: "+json.message);
				} else {
					for(let li=0; li<json.length; li++){
					if(json.data[li].status == "in prenotazione"){
						p_incorso.innerHTML = hb_incorso(json);
					}
					p_old.innerHTML = hb_old(json);
					}
				}
				agganciaEventi();
			})
			.catch(function(err) { 
					alert(err);
					console.log('Failed to fetch page: ', err);
			});	
			
}

function agganciaEventi(event){
	let btn_modifica = document.getElementsByClassName("bottone_modifica");
	for(let li=0; li<brn_modifica.length; li++){
		btn_modifica[li].addEventListener("click", editPrenotazione);
	}

	let btn_cancella = document.getElementsByClassName("bottone_cancella");
	for(let li=0; li<brn_cancella.length; li++){
		btn_cancella[li].addEventListener("click", deletePrenotazione);
	}
}


window.addEventListener(
	'DOMContentLoaded', 
	function(event){

		 p_incorso = document.getElementById("div_attuale");
		 p_old = document.getElementById("div_old");
		 template_incorso = document.getElementById("template_attuale").innerHTML;
		 template_old = document.getElementById("template_old").innerHTML;

		hb_incorso =Handlebars.compile(template_incorso);
		hb_old = Handlebars.compile(template_old);

		loadUtente;
		refreshPrenotazioni(null);
});