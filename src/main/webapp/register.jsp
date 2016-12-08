<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register</title>
</head>
<body>

<form action="/Register" method="post">
    First Name:<input type="text" name="firstName"><br>
    Last Name:<input type="text" name="lastName"><br>
    Username:<input type="text" name="userName"><br>
    Password: <input type="password" name="firstPassword"><br>
    Enter Password again: <input type="password" name="secondPassword"><br>
    <input type="submit" value="Submit">
</form>

</body>