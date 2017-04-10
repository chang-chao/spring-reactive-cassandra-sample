$(document).ready(function() {
	sseApi();
});

function sse() {
	var sse = $.SSE('person/sse', {
		onMessage : function(e) {
			console.log("Message");
			console.log(e);
		}
	});
	sse.start();
}

function sseApi() {
	var es = new EventSource('person/sse');
	es.addEventListener('message', function (event) {
	    console.log(event);
	});
}