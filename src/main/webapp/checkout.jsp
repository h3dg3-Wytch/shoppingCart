<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src = "js/checkout.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
	    html, body {
			height: 100%;
			width:100%;

		}
		body {
	        background: url(images/stockroom.png) no-repeat center center fixed;
	        -webkit-background-size: cover;
	        -moz-background-size: cover;
	        -o-background-size: cover;
	        background-size: cover;
	        /*justify-content:center;*/

		}
		.orderDetails{
			position: relative;
			width:50%;
			left:25%;
			margin-top:30px;
			margin-bottom:30px;
			text-align: center;
			border: 2px #000000 solid;
			border-radius: 30px;
			background:rgba(255,255,255,0.3);
		}
		.container{
			margin-top:30px;
			width:100%;
			position:relative;
			display: flex;
			justify-content: center;
			flex-wrap:wrap;
		}
		.formDiv {
			height: auto;
			padding: 10px;
			border: 2px #000000 solid;
			border-radius: 30px;
			background:rgba(255,255,255,0.3);
			margin:10px;
		}
		input, select{
			display:inline-block;
			float:right;
			width:auto;
			
		}
		button{
			width:100%;
			border-color: black;
			border-radius:5px;
			padding-top:5px;
			padding-bottom: 5px;
			margin-top:10px;
			background:rgba(0,0,0,0.3);
			font-size: 14px;
		}
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

	    .row{
	        padding: 5px;
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
        <li><a href="">Home</a></li>
        <li><a href="Profile">Profile</a></li>
        <li><a href="/inventory.jsp">Inventory</a></li>
        <li><a href="/viewCart.jsp">View Cart</a></li>
        <li class="active"><a href="/checkout.jsp">Checkout</a></li>
        <%
            String adminTag = "";
            if(session.getAttribute("admin").equals("true")){
                adminTag ="<li><a href='/admin.jsp'>Admin</a></li>";
            }
        %>
        <%= adminTag %>
      </ul>
    </div>
  </div>
</nav>
	
    <div class = "orderDetails">
      <h2>Order Details</h2>
      <p>This is where the items and total price will go... well at least the total price has to be somewhere</p>
   	</div>
	<div class = "container">
	    <div class = "formDiv">
	      <h2>Shipping Information</h2>
	      <form>
	        
	        First Name*: <input type="text" id = "shipFirstName" name="shipFirstName">
	        <p id = "shipFirstNameError" style="color:red;"></p>
	        
	        Last Name*: <input type="text" id = "shipLastName" name="shipLastName">
	        <p id = "shipLastnameError" style="color:red;"></p>
	        
	        Street Address*: <input type="text" id = "streetAddress" name="streetAddress">
	        <p id = "addressError" style="color:red;"></p>
	        
	        Zip Code*: <input type="text" id = "zipCode" name="zipCode">
	        <p id = "zipCodeError" style="color:red;"></p>
	        
	        City*: <input type="text" id = "city" name="city">
	        <p id = "cityError" style="color:red;"></p>
	        State:<select>
		         <option value="AL">Alabama</option>
		         <option value="AK">Alaska</option>
		         <option value="AZ">Arizona</option>
		         <option value="AR">Arkansas</option>
		         <option value="CA">California</option>
		         <option value="CO">Colorado</option>
		         <option value="CT">Connecticut</option>
		         <option value="DE">Delaware</option>
		         <option value="DC">District Of Columbia</option>
		         <option value="FL">Florida</option>
		         <option value="GA">Georgia</option>
		         <option value="HI">Hawaii</option>
		         <option value="ID">Idaho</option>
		         <option value="IL">Illinois</option>
		         <option value="IN">Indiana</option>
	           <option value="IA">Iowa</option>
	           <option value="KS">Kansas</option>
	           <option value="KY">Kentucky</option>
	           <option value="LA">Louisiana</option>
	           <option value="ME">Maine</option>
	           <option value="MD">Maryland</option>
	           <option value="MA">Massachusetts</option>
	           <option value="MI">Michigan</option>
	           <option value="MN">Minnesota</option>
	           <option value="MS">Mississippi</option>
	           <option value="MO">Missouri</option>
	           <option value="MT">Montana</option>
	           <option value="NE">Nebraska</option>
	           <option value="NV">Nevada</option>
	           <option value="NH">New Hampshire</option>
	           <option value="NJ">New Jersey</option>
	           <option value="NM">New Mexico</option>
	           <option value="NY">New York</option>
	           <option value="NC">North Carolina</option>
	           <option value="ND">North Dakota</option>
	           <option value="OH">Ohio</option>
	           <option value="OK">Oklahoma</option>
	           <option value="OR">Oregon</option>
	           <option value="PA">Pennsylvania</option>
	           <option value="RI">Rhode Island</option>
	           <option value="SC">South Carolina</option>
	           <option value="SD">South Dakota</option>
	           <option value="TN">Tennessee</option>
	           <option value="TX">Texas</option>
	           <option value="UT">Utah</option>
	           <option value="VT">Vermont</option>
	           <option value="VA">Virginia</option>
	           <option value="WA">Washington</option>
	           <option value="WV">West Virginia</option>
	           <option value="WI">Wisconsin</option>
	           <option value="WY">Wyoming</option>
	         </select>
	         <br>
	         <br>	        
	        Email*: <input type="text" id = "email" name="email">
	        <p id = "emailError" style="color:red;"></p>
	        Phone: <input type="text" id = "phone" name="phone"><br>
	      </form>
	    </div>

	    <div class = "formDiv">
	      <h2>Billing Information</h2>
	      <form>
	       
	        First Name*: <input type="text"  id = "billFirstName" name="billFirstName">
	         <p id = "billFirstNameError" style="color:red;"></p>
	        
	        Last Name*: <input type="text" id = "billLastName" name="billLastName">
	        <p id = "billLastNameError" style="color:red;"></p>
	        
	        Card Number*: <input type="text" id = "cardNumber" name="cardNumber"><p id = "cardError" style="color:red;"></p><br>
	        Expiration date: <select>
	          <option value="jan">01-jan</option>
	          <option value="feb">02-feb</option>
	          <option value="mar">03-mar</option>
	          <option value="apr">04-apr</option>
	          <option value="may">05-may</option>
	          <option value="jun">06-jun</option>
	          <option value="jul">07-jul</option>
	          <option value="aug">08-aug</option>
	          <option value="sep">09-sep</option>
	          <option value="oct">10-oct</option>
	          <option value="nov">11-nov</option>
	          <option value="dec">12-dec</option>
	        </select><select>
	          <option value="2016">2016</option>
	          <option value="2017">2017</option>
	          <option value="2018">2018</option>
	          <option value="2019">2019</option>
	          <option value="2020">2020</option>
	          <option value="2021">2021</option>
	          <option value="2022">2022</option>
	          <option value="2023">2023</option>
	          <option value="2024">2024</option>
	          <option value="2025">2025</option>
	          <option value="2026">2026</option>
	        </select><br>
	        <p id = "securityCodeError" style="color:red;"></p>
	        Security Code*: <input type="text" id = "securityCode" name="securityCode"><br><br>
	        <button type="button"onclick="validateForm(this.form)">Submit</button>
	      </form>
	      <br>
	      <div>
	        <img id = "mastercardImage" src="/images/mastercard.png"style="width:60px;height:60px;">
	        <img id = "visaImage" src="/images/visa.png"style="width:60px;height:60px;">
	        <img id = "americanexpressImage" src="/images/americanexpress.png"style="width:60px;height:60px;">
	        <img id = "discoverImage" src="/images/discover.png"style="width:60px;height:60px;">
	      </div>
	    </div>
	</div>    
  </body>
</html>
