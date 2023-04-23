<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="/webjars/sockjs-client/sockjs.min.js"></script>
		<script src="/webjars/stomp-websocket/stomp.min.js"></script>
		<script src="<c:url value="/js/jquery-3.6.1.min.js"/>"></script>
		<script src="<c:url value='/js/websocket.js'/>"></script>
	</head>
	<body>
		<section id="main-content">
			<section class="wrapper">
				<h3><i class="fa fa-angle-right"></i> WebSocket</h3>
				<div class="row">
				    <div class="col-md-6">
				        <form class="form-inline">
				            <div class="form-group">
								<label for="connect">WebSocket connection:</label>
				                <button id="connect" class="btn btn-default" type="submit">Connect</button>
				                <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
				                </button>
				            </div>
				        </form>
				    </div>
				    <div class="col-md-6">
				        <form class="form-inline">
				            <div class="form-group">
				                <label for="name">What is your name?</label>
				                <input type="text" id="name" class="form-control" placeholder="Your name here...">
				            </div>
				            <button id="send" class="btn btn-default" type="submit">Send</button>
				        </form>
				    </div>
				</div>
				<div class="row">
				    <div class="col-md-12">
				        <table id="conversation" class="table table-striped">
				            <thead>
				            <tr>
				                <th>Greetings</th>
				            </tr>
				            </thead>
				            <tbody id="greetings">
				            </tbody>
				        </table>
				    </div>
				</div>
			</section>
		</section>
	</body>
</html>