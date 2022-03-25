let url="http://localhost:8080/";


function editPrenotazione(event){
	let originator = event.currentTarget;
	let prenotazione_id = originator.getAttribute('data-prenotazione-id');
	console.log("edit id="+prenotazione_id);

	
	if(_bq_array.length>0){

		

		fetch(url+""+encodeURIComponent(prenotazione_id)
			+"&prenotazione="+encodeURIComponent(prenotazione.trim())
			+"&token="+encodeURIComponent(me.token))
		.then(function(response) {
			return response.json();
		})
		.then(function(json) {
				
				console.log(json);

				if(json.result !== 0){
					alert("Error "+json.result+" in editprenotazione: "+json.message);
				}
				refreshprenotaziones();
				
		})
		.catch(function(err) { 
				alert(err);
				console.log('Failed to fetch page: ', err);
		});
	}
	
}


function refreshPrenotazione(event){

	fetch(url+"/api/prenotazioni")
	.then(function(response) {
		return response.json();
	})
	.then(function(json) {
			
		
		let rows = "";

		if(json.result !== 0){
			alert("Error "+json.result+" in prenotazioni: "+json.message);
		} else {
			for(let li=0; li<json.data.length; li++){
				let row = template_prenotazione;
				
				
				rows += row.replaceAll("{{id}}", json.data[li].id)
					.replaceAll("{{veicolo_id}}", json.data[li].veicolo_id)
					.replaceAll("{{data_prenotazione}}", json.data[li].data_prenotazione)
					.replaceAll("{{btn_cancella}}", btn_cancella)
					.replaceAll("{{btn_modifica}}", btn_modifica);
			}
		}
		document.getElementById("prenotaziones-container").innerHTML = rows;
		agganciaEventiAppreciateDeleteEdit();
	})
	.catch(function(err) { 
			alert(err);
			console.log('Failed to fetch page: ', err);
	});	
}







window.addEventListener(
	'DOMContentLoaded', 
	function(event){


    
        let btn_modifica = document.getElementById("bottone_modifica");
        let btn_cancella = document.getElementById("bottone_cancella");
 
    
});