/**
 * 
 */
 
 var stompClient = null;

// connected 상태 변경
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

// WebSocket 접속
function connect() {
    var socket = new SockJS('/gs-guide-websocket');	// WebSocketConfig.java에서 설정한 endpoint
    stompClient = Stomp.over(socket);	// socket을 이용하여 stompClient 생성
    // socket 접속
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        // '/topic/greetings' 메시지 브로커 구독
        // 해당 토픽에 메시지가 게시되면 이 클라이언트가 메시지를 읽어서 클라이언트의 콜백함수를 통해 메시지 전달
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

// WebSocket 접속 끊기
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

// message 보내기
function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

// 서버로부터 받은 메시지 출력
function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});