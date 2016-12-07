<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@page import="com.h3dg3wytch.models.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>

<%

User user = null;
String userName = null;
if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
}else{
    user = (User) session.getAttribute("user");
    userName = user.getUserName();
}
%>
<h3>Hi <%=userName %>, Login successful.></h3>
<br>
User=<%=user %>
<br>

</body>
</html>