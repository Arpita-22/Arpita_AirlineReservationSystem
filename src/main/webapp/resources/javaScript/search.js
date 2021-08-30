
function find (formAction, textFieldId, dataListId) {
	let search = document.getElementById(textFieldId).value;
	let data_list=document.getElementById(dataListId);
		
		
	console.log("Calling search");
	let xmlRequest = new XMLHttpRequest();

	// Initializes the request
	xmlRequest.open('GET',
		'http://localhost:8080/AirlineReservationSystem/' + formAction + '?search=' + search);

	/* Overrides the MIME type returned by the server. For this project, this is 
	 * redundant since the MIME type set in the servlet is "text/xml".*/
	xmlRequest.overrideMimeType('application/json');

	// Runs when the XMLHttpRequest transaction completes successfully
	// Revieves and processes the retrieved data found in XMLHttpRequest.response
	xmlRequest.onload = () => {

		let airports = xmlRequest.responseText;
		airports = airports.replace('[', '');
		airports = airports.replace(']', '');
		airports = airports.replace(/["']/g, '');
		
		let list = airports.split(',');
		list = list.filter(onlyUnique)
		
		var str='';
		for (var i=0; i < list.length; ++i) {
			str += '<option value="'+ list[i] +'" />';
		}
		data_list.innerHTML = str;

	};

	// Sends the request
	xmlRequest.send();
}

function onlyUnique(value, index, self) {
  return self.indexOf(value) === index;
}






