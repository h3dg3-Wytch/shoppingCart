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
</form>
<form action="Register" method="post">
    <input type="submit" value="New user? Register here">
</form>
</body>
</html>