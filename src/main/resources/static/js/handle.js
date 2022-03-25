
async function getVeicoli(){
    let listaVeicoli = await fetch("http://localhost:8080/api/veicoli/categoria/{categoria}")
    let response = await listaVeicoli.json();

    const context = {
        'veicoli': response
    }

    handle("template-table", "ouput-div", context);	

}