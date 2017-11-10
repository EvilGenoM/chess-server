
var ws;
var username = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
	ws = new WebSocket('ws://localhost:8080/ws');
	ws.onmessage = function(data){
		handleMessage(data.data);
	}
	 setConnected(true);
}

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    if(username) {
        if($("#name").val() == "random game") {
            var data = JSON.stringify({'username': username, 'type': 'RANDOM_GAME_FIND'});
        }
    } else {
        var data = JSON.stringify({'username': $("#name").val(), 'type': 'CONNECTION'});
        username = $("#name").val();
    }
    ws.send(data);
}

function handleMessage(message) {
    $("#greetings").append("<tr><td> " + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
});

