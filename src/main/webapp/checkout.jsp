<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src = "/js/checkout.js"></script>
  </head>

  <body>
	
    <div>
      <h2>Order Details</h2>
      <p>This is where the items and total price will go... well at least the total price has to be somewhere</p>
    </div>

    <div>
      <h2>Shipping Information</h2>
      <form>
        <p id = "shipFirstNameError" style="color:red;"></p>
        First Name*: <input type="text" id = "shipFirstName" name="shipFirstName"><br>
        <p id = "shipLastnameError" style="color:red;"></p>
        Last Name*: <input type="text" id = "shipLastName" name="shipLastName"><br>
        <p id = "addressError" style="color:red;"></p>
        Street Address*: <input type="text" id = "streetAddress" name="streetAddress"><br>
        <p id = "zipCodeError" style="color:red;"></p>
        Zip Code*: <input type="text" id = "zipCode" name="zipCode"><br>
        <p id = "cityError" style="color:red;"></p>
        City*: <input type="text" id = "city" name="city"><br><br>
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

        <p id = "emailError" style="color:red;"></p>
        Email*: <input type="text" id = "email" name="email"><br><br>
        Phone: <input type="text" id = "phone" name="phone"><br>
      </form>
    </div>

    <div>
      <h2>Billing Information</h2>
      <form>
        <p id = "billFirstNameError" style="color:red;"></p>
        First Name*: <input type="text"  id = "billFirstName" name="billFirstName"><br>
        <p id = "billLastNameError" style="color:red;"></p>
        Last Name*: <input type="text" id = "billLastName" name="billLastName"><br>
        <p id = "cardError" style="color:red;"></p>
        Card Number*: <input type="text" id = "cardNumber" name="cardNumber"><br><br>
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
      <div>
        <img id = "mastercardImage" src="/images/mastercard.png"style="width:60px;height:60px;">
        <img id = "visaImage" src="/images/visa.png"style="width:60px;height:60px;">
        <img id = "americanexpressImage" src="/images/americanexpress.png"style="width:60px;height:60px;">
        <img id = "discoverImage" src="/images/discover.png"style="width:60px;height:60px;">
      </div>
    </div>
  </body>

</html>
