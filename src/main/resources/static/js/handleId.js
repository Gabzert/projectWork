var botVeicolo = "auto";
getVeicoloByCategoria(botVeicolo);

document.getElementById("auto").addEventListener("click", function(){
     botVeicolo = "auto";
     getVeicoloByCategoria(botVeicolo);
});

document.getElementById("moto").addEventListener("click", function(){
     botVeicolo = "moto";
     getVeicoloByCategoria(botVeicolo);
});

document.getElementById("bici").addEventListener("click", function(){
     botVeicolo = "bici";
     getVeicoloByCategoria(botVeicolo);
});

document.getElementById("monopattino").addEventListener("click", function(){
     botVeicolo = "monopattino";
     getVeicoloByCategoria(botVeicolo);
});



async function getVeicoloByCategoria(){

    
    let response = "";
    let listaVeicoli = "";

     response = await fetch('http://localhost:8080/api/veicoli/categoria/' + botVeicolo);
     listaVeicoli = await response.json();

    const context = {
        'veicoli': listaVeicoli
    };

    

    handle("template-swiper", "ouput-div1", context);	
}

async function getVeicoliCategoriaAndCitta(citta){

     let response = "";
     let listaVeicoli = "";

     response = await fetch('http://localhost:8080/api/veicoli/veicolo/categoria/' + botVeicolo + '/citta/' + citta);
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