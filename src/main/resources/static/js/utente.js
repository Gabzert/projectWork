let url="http://localhost:8080/api/prenotazioni";

let template_old =null;
let template_incorso = null;
let p_old = null;
let p_incorso = null;
let hb_incorso = null;
let hb_old = null;


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

	fetch(url)
	.then(function(response) {
		return response.json();
		
	})
	.then(function(json) {

		console.log(json);

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
		agganciaEventiAppreciateDeleteEdit();
	})
	.catch(function(err) { 
			alert(err);
			console.log('Failed to fetch page: ', err);
	});	
}

/*
Handlebars.registerHelper("if", function(, options) {
	if (conditional) {
	  return 
	}
  });
*/



window.addEventListener(
	'DOMContentLoaded', 
	function(event){

		 p_incorso = document.getElementById("div_attuale");
		 p_old = document.getElementById("div_old");
		 template_incorso = document.getElementById("template_attuale").innerHTML;
		 template_old = document.getElementById("template_old").innerHTML;

		hb_incorso =Handlebars.compile(template_incorso);
		hb_old = Handlebars.compile(template_old);

    
        let btn_modifica = document.getElementById("bottone_modifica");
        let btn_cancella = document.getElementById("bottone_cancella");
 
		refreshPrenotazioni(null);
});