<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@page import="com.h3dg3wytch.models.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Deals, Deals, Deals!</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    body {
          background: url(images/stockroom.png) no-repeat center center fixed;
          -webkit-background-size: cover;
          -moz-background-size: cover;
          -o-background-size: cover;
          background-size: cover;
    }

    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }

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

    .row{
        padding: 5px;

    }
  </style>
</head>
<body>
  <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/shoppingCart"
        user="developer"  password="password"/>

   <sql:query dataSource="${snapshot}" sql="SELECT * FROM product;" var="productResult" />

   <sql:query dataSource="${snapshot}" sql="SELECT * FROM admins;" var="adminResult" />

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>

      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="main.jsp">Home</a></li>
          <li><a href="Profile">Profile</a></li>
          <li class="active"><a href="/inventory.jsp">Inventory</a></li>
          <li><a href="/viewCart.jsp">View Cart</a></li>
          <li><a href="/checkout.jsp">Checkout</a></li>
            <c:forEach var="resultRow" items="${adminResult.rows}">
                                <c:if test="${resultRow.userId == user.userId}">
                                    <li><a href="/admin.jsp">Admin</a></li>
                                </c:if>
             </c:forEach>
        </ul>
        <ul class="nav navbar-nav navbar-right">
                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>  Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="container">
      <form action="AddToCart" method="get">
      <div class='row'>
      <c:forEach varStatus="loop" var="row" items="${productResult.rows}">
          <c:if test="${ loop.index % 3 == 0 }">
                    </div>
                    <div class='row'>
          </c:if>
           <div class="col-sm-4">
                  <div class="panel panel-primary ">
                      <div style="background-color: #504A4B;"class="panel-heading"><c:out value="${row.productName}"/></div>
                      <div class="panel-body"><img style="width:100%; height:100%" src=<c:out value="${row.productImageUrl}"/> class="img-responsive" style="width:100%" alt="Image"></div>
                      <div class="panel-footer"><button name="purchase" value=<c:out value="${row.productId}"/> style="width:100%; height:20px;" type="submit">Purchase!</button></div>
                  </div>
           </div>
       </c:forEach>
       </div>
      </form>
  </div>
</body>
<footer class="container-fluid text-center">
</footer>
</html>