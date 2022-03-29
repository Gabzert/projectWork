async function getVeicoliById(id){

    let categoria1 = "auto";
    let categoria2 = "monopattino";
    let categoria3 = "bicicletta";
    let categoria4 = "moto";

    
    let response = "";
    let listaVeicoli = "";

    if(id == "auto"){
         response = await fetch('http://localhost:8080/api/veicoli/categoria/' + categoria1);
         listaVeicoli = await response.json();
    }else if(id == "monopattino"){
         response = await fetch('http://localhost:8080/api/veicoli/categoria/' + categoria2);
         listaVeicoli = await response.json();
    }else if(id == "bici"){
         response= await fetch('http://localhost:8080/api/veicoli/categoria/' + categoria3);
         listaVeicoli = await response.json();
    }else if(id == "moto"){
         response = await fetch('http://localhost:8080/api/veicoli/categoria/' + categoria4);
         listaVeicoli = await response.json();
    }
    
    const context = {
        'veicoli': listaVeicoli
    };

    

    handle("template-swiper", "ouput-div1", context);	
        //sw = '#' + sw;
        //od = '#' + od;
        
        //let dt =   document.querySelector(sw);
        //let swiper = new DataSwiper(od, {});
}


function handle(idTemplate, idOutput, context) {			
			
    let templateScript = document.getElementById(idTemplate).innerHTML;

    // handlebar
    let template = Handlebars.compile(templateScript);
    let htmlCompilato = template(context);

    let output = document.getElementById(idOutput);
    output.innerHTML = htmlCompilato;
    
}