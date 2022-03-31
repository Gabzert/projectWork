
const loc = document.getElementById("textRicerca");

const localitaForm = document.getElementById("location");

const gpsForm = document.getElementById("gps");

async function getLoc(){
    console.log(loc.value);

    	// Docs
	// https://docs.mapbox.com/api/search/geocoding/

	// token mapbox
	const token = 'pk.eyJ1Ijoia3VtYWRkIiwiYSI6ImNsMTU5bnczMDA0MTUzYnMxeHRuaXd5MGsifQ.UinLQwwjt_xzZZLbIkAz1Q';
	let encodedText = encodeURIComponent(loc.value);
	const URL = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + encodedText + ".json?limit=1&country=IT&language=it&access_token=" + token;

	
    let res = await fetch(URL).then(response => response.json()).catch(error => console.log(error));
    console.log(res);

    localitaForm.value = res.features[0].place_name;
    gpsForm.value = res.features[0].center[1] + "," + res.features[0].center[0];

};


async function getLoc1(){
    const loc1 = document.getElementById("textRicerca1");
    const localitaForm1 = document.getElementById("location1");
    const gpsForm1 = document.getElementById("gps1");

    console.log(loc1.value);
    	// Docs
	// https://docs.mapbox.com/api/search/geocoding/

	// token mapbox
	const token = 'pk.eyJ1Ijoia3VtYWRkIiwiYSI6ImNsMTU5bnczMDA0MTUzYnMxeHRuaXd5MGsifQ.UinLQwwjt_xzZZLbIkAz1Q';
	let encodedText = encodeURIComponent(loc1.value);
	const URL = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + encodedText + ".json?limit=1&country=IT&language=it&access_token=" + token;

	
    let res = await fetch(URL).then(response => response.json()).catch(error => console.log(error));
    console.log(res);

    localitaForm1.value = "";
    gpsForm1.value = "";

    localitaForm1.value = res.features[0].place_name;
    gpsForm1.value = res.features[0].center[1] + "," + res.features[0].center[0];
};



