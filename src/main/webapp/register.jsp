<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register</title>
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
			width: auto;
			height: auto;
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
				opacity: 0.75;
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
			margin-top:40px;
			background:rgba(0,0,0,0.3);
			font-size: 14px;
		}
		form .error {
			
			flex-wrap: wrap;
 			color: #ff0000;
		}
	</style>
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<script src="js/register.js"></script>

</head>
<body>
	<div id = "mainForm">
		<form action="/Register" method="post" name="registrationForm">
		    <label for="firstName">First Name:</label>
		    <input type="text" name="firstName"><br>
		    <label for="lastName">Last Name:</label>
		    <input type="text" name="lastName"><br>
		    <label for="userName">Username:</label>
		    <input type="text" name="userName"><br>
		    <label for="password">Password:</label>
		    <input type="password" name="firstPassword" id="firstPassword"><br>
		    <label for="secondPassword">Enter Password again:</label>
		    <input type="password" name="secondPassword"><br>
		    <br>
		    <button type="submit">Register</button>
		</form>
	</div>
</body>
</html>