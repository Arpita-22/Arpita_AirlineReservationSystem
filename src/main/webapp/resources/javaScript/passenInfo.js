
var paxIndex = 2;

function addPassenger() {
	let div = document.getElementById("passengerDetails");
	let text = document.createElement('div');
    text.innerHTML = getFormContent();
    div.appendChild(text);
	
	paxIndex++;	
};

function removePassenger(index) {
	let element = document.getElementById("fieldSet" + index);
    element.parentNode.removeChild(element);
};

function getFormContent(){
	return "<fieldset id=\"fieldSet" + paxIndex + "\">"+"<legend stye=\"display:inline-block;\"><h3>Passenger details</h3></legend>"
			+ 	"<input type=\"button\" id=\"removePax\" value=\"Remove passenger\" onClick= \"removePassenger(" + paxIndex + ")\"/>" 
			+   "</br><label name=\"passengerList[" + paxIndex + "].firstName\" for=\"firstName\">First Name</label>" 
			+	"<input name=\"passengerList[" + paxIndex + "].firstName\" id=\"firstName" + paxIndex + "\" type=\"text\" placeholder=\"firstName\"/>"
			+	"<errors name=\"passengerList[" + paxIndex + "].firstName\" class=\"form-errors\" />"
			+	"<br />"
			+	"<label name=\"passengerList[" + paxIndex + "].lastName\" for=\"lastName\">Last Name</label>"
			+	"<input name=\"passengerList[" + paxIndex + "].lastName\" id=\"lastName" + paxIndex + "\" type=\"text\" placeholder=\"lastName\" />"
			+	"<errors name=\"passengerList[" + paxIndex + "].lastName\" class=\"form-errors\" />"
			+	"<br />"
			+	"<label name=\"passengerList[" + paxIndex + "].email\" for=\"email\">Email</label>"
			+	"<input name=\"passengerList[" + paxIndex + "].email\" id=\"email" + paxIndex + "\" type=\"email\" placeholder=\"email\" />"
			+	"<errors name=\"passengerList[" + paxIndex + "].email\" class=\"form-errors\" />"
			+	"<br />"
			+	"<label name=\"passengerList[" + paxIndex + "].dateOfBirth\" for=\"dateOfBirth\">DateOfBirth</label>"
			+	"<input name=\"passengerList[" + paxIndex + "].dateOfBirth\" id=\"dateOfBirth" + paxIndex + "\" type=\"date\" placeholder=\"dateOfBirth\" />"
			+	"<errors name=\"passengerList[" + paxIndex + "].dateOfBirth\" class=\"form-errors\" />"
			+	"<br />"
			+	"<label name=\"passengerList[" + paxIndex + "].gender\" for=\"gender\">Gender</label>"
			+	"<input name=\"passengerList[" + paxIndex + "].gender\" id=\"gender" + paxIndex + "\" type=\"text\" placeholder=\"gender\" />"
			+	"<errors name=\"passengerList[" + paxIndex + "].gender\" class=\"form-errors\" />"
			+	"<br />"
			+	"<label name=\"passengerList[" + paxIndex + "].personalId\" for=\"personalId\">Personal ID</label>"
			+	"<input name=\"passengerList[" + paxIndex + "].personalId\" id=\"personalId" + paxIndex + "\" type=\"text\" placeholder=\"personalId\" />"
			+	"<errors name=\"passengerList[" + paxIndex + "].personalId\" class=\"form-errors\" /><br/>"
			+   "</fieldset>";
}
