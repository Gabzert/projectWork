let veicolo_id = null;

async function getVeicoloById(id) {

    let response = await fetch('http://localhost:8080/api/veicoli/veicolo/' + id);
    let veicolo = await response.json();

    veicolo_id = id;

    const context = {
        'veico': veicolo
    };

    handle("template-swiper", "ouput-div", context);
}


function prenota(event) {

    fetch("http://localhost:8080/api/utenti/utente")
        .then(function (response) {
            if (!response.ok) {
                window.location.assign("http://localhost:8080/login")
            }else{
            return response.json();
            }
        })
        .then(function (json) {
            utente_id = json.id;
            data_selezionata = document.getElementById("data").value;
            if (data_selezionata == "") {
                alert("Selezionare data della prenotazione")
            } else {
                fetch("http://localhost:8080/api/prenotazioni/addPrenotazione", {
                    method: "POST",
                    headers: {'Content-Type': 'application/json'},
                    
                    body: JSON.stringify({
                        "status": "in prenotazione",
                        "veicolo_id" : veicolo_id,
                        "utente_id": utente_id,
                        "data_prenotazione": data_selezionata
                    })
                }).then(res => {
                    console.log("Request complete! response:", res);
                }).then(function(){
                    window.location.assign("http://localhost:8080/utente");
                });
            }
        })
 }


function handle(idTemplate, idOutput, context) {

    let templateScript = document.getElementById(idTemplate).innerHTML;

    // handlebar
    let template = Handlebars.compile(templateScript);
    let htmlCompilato = template(context);

    let output = document.getElementById(idOutput);
    output.innerHTML = htmlCompilato;

    let btn_prenota = document.getElementById("bottone_prenota");
    btn_prenota.addEventListener("click",prenota)
}


window.addEventListener(
    'DOMContentLoaded',
    function (event) {


    });


