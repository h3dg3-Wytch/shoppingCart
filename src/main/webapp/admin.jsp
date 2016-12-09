<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@page import="com.h3dg3wytch.models.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }

    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }

    input[type=checkbox], input[type=radio] {
      vertical-align: middle;
      position: relative;
      bottom: 1px;
    }

    input[type=radio] {
      bottom: 2px;
    }

    #inputs{
        margin: 5px;
    }

  }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="">Home</a></li>
        <li><a href="/profile.jsp">Profile</a></li>
        <li><a href="/inventory.jsp">Inventory</a></li>
        <li><a href="/viewVart">View Cart</a></li>
        <li><a href="/checkout.jsp">Checkout</a></li>

        <%
            String adminTag = "";
            if(session.getAttribute("admin").equals("true")){
                adminTag ="<li><a href='/admin.jsp'>Admin</a></li>";
            }
        %>
        <%= adminTag %>

      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container text-center">
  <%
  User user = null;
  String userName = null;
  if(session.getAttribute("user") == null){
      response.sendRedirect("login.jsp");
  }else{
      user = (User) session.getAttribute("user");
      userName = user.getFirstName();
  }
  %>
  <h3>Hello Admin <%=userName %>, here are the current users.</h3>

 <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
      url="jdbc:mysql://localhost/shoppingCart"
      user="developer"  password="password"/>

 <sql:query dataSource="${snapshot}" sql="SELECT * FROM user;" var="result" />
  <sql:query dataSource="${snapshot}" sql="SELECT * FROM admins;" var="admin" />


<div class="row">

 <%
    String booleanString = "";
    String error= "";
    if(session.getAttribute("doubleAdminError") != null){
        booleanString = (String) session.getAttribute("doubleAdminError");
        if(booleanString.equals("true")){
            error ="User is already and admin!";
        }
    }
 %>

 <h3><%=error%></h3>

    <form action="Admin" method="post">


     <input type="submit" name="delete" value="Delete User"/>
     <input type="submit" name="addAdmin" value="Make Admin"/>
     <input type="submit" name="removeAdmin" value="Remove Admin"/>

     <table>
     <div id="inputs">
     <c:forEach var="row" items="${result.rows}">
        <tr><label>
        <input type="radio" name="user" value=<c:out value="${row.userId}"/>>
        <c:out value="User ID: ${row.userId}"/>
        <c:out value="First Name: ${row.firstName}"/>
        <c:out value="Last Name: ${row.lastName}"/>
        <c:out value="User Name: ${row.userName}"/>
        <c:forEach var="adminRow" items="${admin.rows}">
           <c:if test="${row.userId eq adminRow.userId}">
                                 <c:out value="Admin: Yes"/>
            </c:if>

        </c:forEach>
        </input></label></tr>
     </c:forEach>
     </table>

     </div>

     </form>





</div>
</div><br>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
