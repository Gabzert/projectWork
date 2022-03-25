
putPosizione();

async function putPosizione() {
  const posizione = await loadMap();
  const p = posizione.gps;
  const split = p.split(',');

  var map = L.map('map').setView([split[0], split[1]], 13);


  L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1Ijoia3VtYWRkIiwiYSI6ImNsMTU5bnczMDA0MTUzYnMxeHRuaXd5MGsifQ.UinLQwwjt_xzZZLbIkAz1Q'
  }).addTo(map);


  var marker = L.marker([split[0], split[1]]).addTo(map);
}

async function loadMap() {

  const id = 2;

  let response = await fetch('http://localhost:8080/api/veicoli/location/' + id);
  let art = await response.json();

  return art;
}
