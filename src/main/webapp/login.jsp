<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Page</title>
</head>
<body>

<form action="LoginServlet" method="post">

    Username: <input type="text" name="user">
    <br>
    Password: <input type="password" name="password">
    <br>
    <input type="submit" value="Login">
    <button type="button"><a href="register.jsp">New User?</button>

</form>
</body>
</html>