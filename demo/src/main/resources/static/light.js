function turnLightOn()  {
  var img = document.getElementById("lightStatus");
  img.src = "css/images/light-on.gif";
}
 
function turnLightOff()  {
  var img = document.getElementById("lightStatus");
  img.src = "css/images/light-off.gif";
}
var status = 0;
document.addEventListener("DOMContentLoaded",function() {
	var url = "http://localhost:8080/api/controll";
	  var aPromise = fetch(url);
	  // Work with Promise object:
	  aPromise
	    .then(function(response) {
	        if(!response.ok) {
	           throw new Error("HTTP error, status = " + response.status);
	        }
	        // Get JSON Promise from response object:
	        var myJSON_promise = response.json();
	        // Work with Promise object:
	        myJSON_promise.then(function(myJSON)  {
	          console.log("OK! JSON:");
	          console.log(myJSON);
	          console.log("status" + myJSON.status);
	          status = myJSON.status;
		        if (status == 0){
		    		turnLightOff();
		    	}
		    	else{
		    		turnLightOn();
		    	}
	        });
	        
	    })
	    .catch(function(error)  {
	        console.log("Noooooo! Something error:");
	        console.log(error);
	        
	    });
});
function turnLight(){
	if (status == 0){
		turnLightOn();
		status = 1;
	}
	else{
		turnLightOff();
		status = 0;
	}	
}
function turn() {
	
	var request = new XMLHttpRequest();
	turnLight();
	request.open("PUT","http://localhost:8080/api/controll/"+status, "false");
	
	request.setRequestHeader("Content-Type","application/json","charset = UTF-8");
	request.send(status);
}
