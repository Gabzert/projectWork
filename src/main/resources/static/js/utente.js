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
	let prenotazione_veicolo = originator.getAttribute('data-prenotazione-veicolo');
	let prenotazione_data = originator.getAttribute('data-prenotazione-data');
	
		document.getElementById("input_id").value = prenotazione_id;
		document.getElementById("input_veicolo").value = prenotazione_veicolo;
		document.getElementById("input_data").value = prenotazione_data;
		
		prenotazioneModal.show();
	}




function salvaModifiche(event){
	let originator = event.currentTarget;
	
	
	let prenotazione_id = document.getElementById("input_id").value;
	let prenotazione_veicolo = document.getElementById("input_veicolo").value;
	let prenotazione_data = document.getElementById("input_data").value;
	



	/*	fetch(url+""+encodeURIComponent(prenotazione_id)
			+"&prenotazione="+encodeURIComponent(prenotazione.trim())
			
		.then(function(response) {
			return response.json();
		})
		.then(function(json) {
				
				

				if(json.result !== 0){
					alert("Error "+json.result+" in editprenotazione: "+json.message);
				}
				refreshPrenotazioni();
			
		})
		.catch(function(err) { 
				alert(err);
				console.log('Failed to fetch page: ', err);
		})	
		*/
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

		if(json.result !== 0){
			alert("Error "+json.result+" in prenotazioni: "+json.message);
		} else {
			if(json.data.status == "in prenotazione"){
				p_incorso.innerHTML = hb_incorso(json);
			}
			p_old.innerHTML = hb_old(json);

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
 
		refreshPrenotazioni();
});