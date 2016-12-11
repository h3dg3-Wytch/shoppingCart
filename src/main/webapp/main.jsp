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
      ""
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="main.jsp">Home</a></li>
        <li><a href='Profile'>Profile</a></li>
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

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img style="width:500px; height: 500px;" src="images/deals.png" alt="Image">
        <div class="carousel-caption">
          <h3 style="color: black">DEALS, DEALS, DEALS</h3>
          <p style="color: black">Give me your money</p>
        </div>
      </div>

      <div class="item">
        <img style="width:500px; height: 500px;"src="images/bigdeal.png" alt="Image">
        <div class="carousel-caption">
          <h3 style="color: black">Ha ha CAPITALISM</h3>
          <p style="color: black">We want your money, honey!</p>
        </div>
      </div>

       <div class="item">
              <img style="width:500px; height: 500px;" src="images/hot.png" alt="Image">
              <div class="carousel-caption">
                <h3 style="color: black">We love Dinero</h3>
                <p style="color: black">Pure Cheddar</p>
              </div>
            </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

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
  <h3>Hi <%=userName %>, Login successful.</h3><br/>
  <hr>


  <div class="row">
    <div class="col-sm-4">
      <img src="images/person.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>Trust me</p>
    </div>
    <div class="col-sm-8">
      <h3>Fine Products, Better Deals</h3>

      <p>Oh boy, I love to make deals? What is the deal with that, haha. How do you deal with these great deals?</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla sodales arcu ac magna consectetur consequat.
      Aenean nec rhoncus elit. Cras varius iaculis efficitur. Nulla et massa orci. Vestibulum ornare nisl non purus semper,
       ut mollis odio ullamcorper. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
       Cras facilisis orci at elit venenatis, sit amet luctus ipsum scelerisque.</P>

       <p>Vivamus metus turpis, suscipit at feugiat a, finibus vel sapien.
       Pellentesque diam magna, laoreet id pharetra et, auctor vitae est.
       Integer non ligula egestas, pharetra sapien et, faucibus eros.
       Cras nec orci pretium ante dictum vestibulum. In ullamcorper enim in justo imperdiet,
        faucibus tristique metus semper. Etiam suscipit in enim sit amet facilisis.
        Integer non ullamcorper sapien, et viverra augue. Proin pellentesque sapien lectus,
        sed imperdiet nisi ultricies non. Donec eu sollicitudin ante. Aenean et orci ornare,
        lobortis turpis ut, viverra justo. Curabitur imperdiet tempor arcu, nec vulputate nibh
         faucibus sed. Aliquam non hendrerit est, at sagittis libero. Quisque eget quam
          in dolor rhoncus scelerisque.</p>
    </div>

  </div>
</div><br>

<footer style="background-color: #504A4B" class="container-fluid text-center">
  <p></p>
</footer>

</body>
</html>
