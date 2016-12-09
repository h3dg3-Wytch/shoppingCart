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

  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
      min-height:200px;
  }

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none;
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

    <form action="Admin" method="post">
     <table>
     <th>User Id</th><th>First Name</th><th>Last Name</th><th>User Name</th><th>Admin</th>
     <c:forEach var="row" items="${result.rows}">
        <input type="checkbox" name="row.userId" value="userId"></input><br/>
            <td></td>
            <td><c:out value="${row.firstName}"/></td>
            <td><c:out value="${row.lastName}"/></td>
            <td><c:out value="${row.userName}"/></td>
            <td>
                <c:forEach var="adminRow" items="${admin.rows}">
                    <c:if test="${row.userId eq adminRow.userId}">
                         <c:out value="Yes"/>
                    </c:if>
                    <c:if test="${row.userId != adminRow.userId}">
                       <c:out value="No"/>
                    </c:if>
                </c:forEach>
            </td>


        </tr>
        </input>
     </c:forEach>
      </table>

    <form action="Admin" method="post">
        <input type ="Submit" value= "Submit">
    </form>
</div>
</div><br>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
