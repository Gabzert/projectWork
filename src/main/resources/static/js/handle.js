
async function getVeicoli(){

    let categoria1 = "auto";
    let categoria2 = "monopattino";
    let categoria3 = "bicicletta";
    let categoria4 = "moto";
    
    let responseAuto = await fetch('http://localhost:8080/api/veicoli/categoria/' + categoria1);
    let responseMonopattini = await fetch('http://localhost:8080/api/veicoli/categoria/' + categoria2);
    let responseBici= await fetch('http://localhost:8080/api/veicoli/categoria/' + categoria3);
    let responseMoto = await fetch('http://localhost:8080/api/veicoli/categoria/' + categoria4);

    let listaAuto = await responseAuto.json();
    let listaMonopattini = await responseMonopattini.json();
    let listaBici = await responseBici.json();
    let listaMoto = await responseMoto.json();

    let arrayJson = [listaMoto,listaMonopattini,listaAuto,listaBici];


    for(let i = 1 ; i<=arrayJson.length; i++){
        let sw = 'swiper_veicoli' + i;

        const context = {
            'veicoli' : arrayJson[i-1]
        }
        
        let ts = "template-swiper";
        let od = "ouput-div" + i;

        handle(ts, od, context);

        //sw = '#' + sw;
        //od = '#' + od;
        
        //let dt =   document.querySelector(sw);
        //let swiper = new DataSwiper(od, {});
    }

    




/*
    const context1 = {
        'auto': listaAuto
    }
    const context2 = {
        'monopattini': listaMonopattini
    }
    const context3 = {
        'bici': listaBici
    }
    const context4 = {
        'moto': listaMoto
    }
    
 
    handle("template-swiper1", "ouput-div1", context1);	
    handle("template-swiper2", "ouput-div2", context2);	
    handle("template-swiper3", "ouput-div3", context3);	
    handle("template-swiper4", "ouput-div4", context4);	
    */


/*
    let dt1 =   document.querySelector('#swiper_veicoli1');
	let swiper1 = new DataSwiper(dt, {});

    let dt2 =   document.querySelector('#swiper_veicoli2');
	let swiper2 = new DataSwiper(dt, {});

    let dt3 =   document.querySelector('#swiper_veicoli3');
	let swiper3 = new DataSwiper(dt, {});
    
    let dt4 =   document.querySelector('#swiper_veicoli4');
	let swiper4 = new DataSwiper(dt, {});*/

}




function handle(idTemplate, idOutput, context) {			
			
    let templateScript = document.getElementById(idTemplate).innerHTML;

    // handlebar
    let template = Handlebars.compile(templateScript);
    let htmlCompilato = template(context);

    let output = document.getElementById(idOutput);
    output.innerHTML = htmlCompilato;
    
}