async function getVeicoloById(id){

    let response = await fetch('http://localhost:8080/api/veicoli/veicolo/' + id);
    let veicolo = await response.json();


    const context = {
        'veico': veicolo
    };

    handle("template", "ouput-div", context);
}


function handle(idTemplate, idOutput, context) {			
			
    let templateScript = document.getElementById(idTemplate).innerHTML;

    // handlebar
    let template = Handlebars.compile(templateScript);
    let htmlCompilato = template(context);

    let output = document.getElementById(idOutput);
    output.innerHTML = htmlCompilato;
    
}