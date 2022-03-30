async function getVeicoliPannel(){

     let response = await fetch('http://localhost:8080/api/admin/getVeicoliList')
     let listaVeicoli = await response.json();

    
    const context = {
        'veicoli': listaVeicoli
    };

    

    handle("template-swiper", "ouput-div", context);	
}


function handle(idTemplate, idOutput, context) {			
			
    let templateScript = document.getElementById(idTemplate).innerHTML;

    // handlebar
    let template = Handlebars.compile(templateScript);
    let htmlCompilato = template(context);

    let output = document.getElementById(idOutput);
    output.innerHTML = htmlCompilato;
    
}