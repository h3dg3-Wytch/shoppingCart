<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Page</title>
    <style>
	    html, body {
			height: 100%;
		}
		body {
	        background: url(images/stockroom.png) no-repeat center center fixed;
	        -webkit-background-size: cover;
	        -moz-background-size: cover;
	        -o-background-size: cover;
	        background-size: cover;
		}
		#mainForm {
			display: flex;
			justify-content: center;
			align-content: center;
			width: 300px;
			height: 150px;
			left: 50%;
			top: 50%;
			position:absolute;
			transform: translate(-50%, -50%);
			padding: 30px;
			border: 2px #000000 solid;
			border-radius: 30px;
			background:rgba(255,255,255,0.3);
			animation: mainAnimation .5s ease-in-out;
		}
		@keyframes mainAnimation {
			0% {
				transform: translate(-50%, -75%);
				opacity: 0;
			}
			50%{
				transform: translate(-50%, -50%);
				opacity: 0.33;
			}
			75%{
				transform: translate(-50%, -55%);
				opacity: 0.66;
			}
			100% {
				transform: translate(-50%, -50%);
				opacity: 1;
			}
		}
		input{

			width:100%;
		}
		button{
			width:100%;
			border-color: black;
			border-radius:5px;
			padding-top,padding-bottom: 5px;
		}
	</style>
</head>
<body>
<div id = "mainForm">
	<form action="LoginServlet" method="post">

	    Username: <input type="text" name="user">
	    <br>
	    Password: <input type="password" name="password">
	    <br>
	    <br>
	    <button type="submit" value="Login">Sign In</button>
	    <hr>
	    <button type="button"><a href="register.jsp">Create your Account</button>
	</form>
</div>
</body>
</html>