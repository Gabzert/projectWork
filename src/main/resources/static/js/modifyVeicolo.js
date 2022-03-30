

async function modifyVeicolo(id){
    let response = await fetch('http://localhost:8080/api/veicoli/veicolo/' + id);
    let veicolo1 = await response.json();

    const context = {
        'veicolo': veicolo1
    };

    handle1("template-swiper1", "ouput-div1", context);

    $("#update").modal('show');

}

function handle1(idTemplate, idOutput, context) {			
			
    let templateScript = document.getElementById(idTemplate).innerHTML;

    // handlebar
    let template = Handlebars.compile(templateScript);
    let htmlCompilato = template(context);

    let output = document.getElementById(idOutput);
    output.innerHTML = htmlCompilato;
    
}
