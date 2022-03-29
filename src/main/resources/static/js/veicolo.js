let url="http://localhost:8080/";



function caricaVeicolo(){
    fetch(url+"api/veicoli/getbyid")
	.then(function(response) {
		return response.json();
	})
	.then(function(json) {
    

		if(json.result !== 0){
			alert("Error "+json.result+" in veicolo: "+json.message);
		} else {	
				let row = "";
				

				rows += row.replaceAll("{{img}}", json.img )
					.replaceAll("{{name}}", json.name)
					.replaceAll("{{descrizione}}",json.descrizione )
					.replaceAll("{{}}", )
					.replaceAll("{{}}",)
					
			}
		
		document.getElementById("thoughts-container").innerHTML = rows;
		agganciaEventiAppreciateDeleteEdit();
	})
	.catch(function(err) { 
			alert(err);
			console.log('Failed to fetch page: ', err);
	});	
}








function prenota(event){

    fetch(url+"/api/prenotazioni/addprenotazione",{
        method: "POST",
        redirect: url+"/api/prenotazioni",
        body: JSON.stringify(data_veicolo)
    });
    

}



window.addEventListener(
	'DOMContentLoaded', 
	function(event){




    let img = document.getElementById("immagine_veicolo")

	let btn_prenota = document.getElementById("bottone_prenota");
		
	btn_prenota.addEventListener("click",prenota);
    
});