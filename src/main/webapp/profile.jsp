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
  <title>Deals, Deals, Deals!</title>
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

        #userInfo{
          height:200px;
          width:100%;
          background-color: #666362;
          margin: 5px;
        }

        #pastPurchases{
           height:100%;
            width:100%;
            background-color: #666362;
            margin: 5px;


        }

        .order{
            width: 100%;
            height:100%;
            margin-bottom: 10px;
            background-color: grey;

        }

        img{
            margin: 5px;
            height: 90px;
            width: 100px;
            float: right;
        }

  }
  </style>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
               url="jdbc:mysql://localhost/shoppingCart"
               user="developer"  password="password"/>


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
        <li class="active"><a href="Profile">Profile</a></li>
        <li><a href="/inventory.jsp">Inventory</a></li>
        <li><a href="/viewCart.jsp">View Cart</a></li>
        <li><a href="/checkout.jsp">Checkout</a></li>
        <c:forEach var="resultRow" items="${adminResult.rows}">
                    <c:if test="${resultRow.userId == user.userId}">
                        <li><a href="/admin.jsp">Admin</a></li>
                    </c:if>
        </c:forEach>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">

<div class="row">

    <div id="userInfo" class="col-md-6 offset-md-3 text-center">
        <h3>First Name:<c:out value="${user.firstName}"/></h3>
        <h3>Last Name:<c:out value="${user.lastName}"/></h3>
        <h3>User Name:<c:out value="${user.userName}"/></h3>
    </div>

</div>

<div class="row">
    <h1>Order History</h1>
    <div id="pastPurchases" class="col-md-6 offset-md-3">
        <c:forEach var="order" items="${orderHistory}">
        <div class="order">
            <img src=<c:out value="${order.imageUrl}"/> />
            <h2>Product Name: <c:out value="${order.productName}"/></h2>
            <h2>Product Price: <c:out value="${order.productPrice}"/></h2>
        </div>
        </c:forEach>

    </div>

</div>

</div>
<footer class="container-fluid text-center">
</footer>

</body>
</html>
