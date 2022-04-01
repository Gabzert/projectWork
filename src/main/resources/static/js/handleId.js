var botVeicolo = "auto";

var checkDispo = "disponibile"

var checkCitta = "Milano";

getVeicoliCategoriaAndCittaAndDisponibilita();

//EVENT CATEGORIA
document.getElementById("auto").addEventListener("click", function(){
     botVeicolo = "auto";
     getVeicoliCategoriaAndCittaAndDisponibilita();
});

document.getElementById("moto").addEventListener("click", function(){
     botVeicolo = "moto";
     getVeicoliCategoriaAndCittaAndDisponibilita();
});

document.getElementById("bici").addEventListener("click", function(){
     botVeicolo = "bicicletta";
     getVeicoliCategoriaAndCittaAndDisponibilita();
});

document.getElementById("monopattino").addEventListener("click", function(){
     botVeicolo = "monopattino";
     getVeicoliCategoriaAndCittaAndDisponibilita();
});

//EVENT CITTA

document.getElementById("cityFilter").addEventListener("change", function(){
     checkCitta = document.getElementById("cityFilter").value;
     getVeicoliCategoriaAndCittaAndDisponibilita();
});

//EVENT DISPONIBILITA
document.getElementById("disponibili").addEventListener("click", function(){
     checkDispo = "disponibile";
     getVeicoliCategoriaAndCittaAndDisponibilita();
});

document.getElementById("non-disponibili").addEventListener("click", function(){
     checkDispo = "non disponibile";
     getVeicoliCategoriaAndCittaAndDisponibilita();
});


/*
async function getVeicoloByCategoria(){

    
    let response = "";
    let listaVeicoli = "";

     response = await fetch('http://localhost:8080/api/veicoli/categoria/' + botVeicolo);
     listaVeicoli = await response.json();

    const context = {
        'veicoli': listaVeicoli
    };

    

    handle("template-swiper", "ouput-div1", context);	
}*/

/*
async function getVeicoliCategoriaAndCitta(citta){

     let response = "";
     let listaVeicoli = "";

     response = await fetch('http://localhost:8080/api/veicoli/veicolo/categoria/' + botVeicolo + '/citta/' + citta);
     listaVeicoli = await response.json();


     
     const context = {
         'veicoli': listaVeicoli
     };
 
     
 
     handle("template-swiper", "ouput-div1", context);	
}*/


async function getVeicoliCategoriaAndCittaAndDisponibilita(){

     let response = "";
     let listaVeicoli = "";

     response = await fetch('http://localhost:8080/api/veicoli/veicolo/categoria/' + botVeicolo + '/citta/' + checkCitta + '/dispo/' + checkDispo);
     listaVeicoli = await response.json();


     
     const context = {
         'veicoli': listaVeicoli
     };
 
     
 
     handle("template-swiper", "ouput-div1", context);
     
     
}

function handle(idTemplate, idOutput, context) {			
			
    let templateScript = document.getElementById(idTemplate).innerHTML;

    // handlebar
    let template = Handlebars.compile(templateScript);
    let htmlCompilato = template(context);

    let output = document.getElementById(idOutput);
    output.innerHTML = htmlCompilato;
    
}