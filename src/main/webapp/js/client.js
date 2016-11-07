var ws;
function init() {
	outputArea = document.getElementById("output");
}

function sayHello() {
	if (!window.WebSocket){
	    console.log("This browser does not support WebSocket!");
	    return;
	} 
	var url = "ws://localhost:8080/websocketDemo/hello";
	writeMessageToScreen("Connecting to " + url);
	ws = new WebSocket(url);
	ws.onopen = function(event) {
		writeMessageToScreen("Connected.");
		var message = document.getElementById("message").value;
		doSend(message);
	}

	ws.onmessage = function(event) {
		writeMessageToScreen("Received message: " + event.data);
		ws.close();
	}

	ws.onerror = function(event) {
		writeMessageToScreen("Occur Error:<span style='color:red'>"
				+ event.data + "</span>");
		ws.close();
	}
}

function doSend(message) {
	ws.send(message);
	writeMessageToScreen("Sent message: " + message);
}

function writeMessageToScreen(message) {
	var p = document.createElement("p");
	p.style.wordWrap = "break-word";
	p.innerHTML = message;
	outputArea.appendChild(p);
}

this.addEventListener("load", init, false);
