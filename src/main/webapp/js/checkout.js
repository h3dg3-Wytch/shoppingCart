
$(document).ready(function()
{
    $("#cardNumber").keydown(function (e)
    {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
            (e.keyCode == 65 && e.ctrlKey === true) ||
            (e.keyCode == 67 && e.ctrlKey === true) ||
            (e.keyCode == 88 && e.ctrlKey === true) ||
            (e.keyCode >= 35 && e.keyCode <= 39))
            {
                 return;
            }

        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105))
        {
            e.preventDefault();
        }
    });

    $("#securityCode").keydown(function (e)
    {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
            (e.keyCode == 65 && e.ctrlKey === true) ||
            (e.keyCode == 67 && e.ctrlKey === true) ||
            (e.keyCode == 88 && e.ctrlKey === true) ||
            (e.keyCode >= 35 && e.keyCode <= 39))
            {
                 // let it happen, don't do anything
                 return;
            }

        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105))
        {
            e.preventDefault();
        }
    });

    $("#phone").keydown(function (e)
    {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
            (e.keyCode == 65 && e.ctrlKey === true) ||
            (e.keyCode == 67 && e.ctrlKey === true) ||
            (e.keyCode == 88 && e.ctrlKey === true) ||
            (e.keyCode >= 35 && e.keyCode <= 39))
            {
                 return;
            }

        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105))
        {
            e.preventDefault();
        }
    });

    $("#shipFirstName").keyup(function (e)
    {
      if($(this).val() != "")
      {
        $("#shipFirstNameError").html("");
      };
    });

    $("#shipLastName").keyup(function (e)
    {
      if($(this).val() != "")
      {
        $("#shipLastnameError").html("");
      };
    });

    $("#streetAddress").keyup(function (e)
    {
      if($(this).val() != "")
      {
        $("#addressError").html("");
      };
    });

    $("#zipCode").keyup(function (e)
    {
      if($(this).val() != "")
      {
        $("#zipCodeError").html("");
      };
    });

    $("#city").keyup(function (e)
    {
      if($(this).val() != "")
      {
        $("#cityError").html("");
      };
    });

    $("#email").keyup(function (e)
    {
      if($(this).val() != "")
      {
        $("#emailError").html("");
      };
    });

    $("#billFirstName").keyup(function (e)
    {
      if($(this).val() != "")
      {
        $("#billFirstNameError").html("");
      };
    });

    $("#billLastName").keyup(function (e)
    {
      if($(this).val() != "")
      {
        $("#billLastNameError").html("");
      };
    });

    $("#securityCode").keyup(function (e)
    {
      if($(this).val() != "")
      {
        $("#securityCodeError").html("");
      };
    });

    $("#cardNumber").keyup(function (e)
    {
      updatedCard($(this).val());
    });
});

function updatedCard(cardNumber)
{
  $("#mastercardImage").css("opacity",1.0);
  $("#visaImage").css("opacity",1.0);
  $("#americanexpressImage").css("opacity",1.0);
  $("#discoverImage").css("opacity",1.0);

  if(cardNumber != "")
  {
    $("#cardError").html("");

    if(cardNumber.startsWith("51", 0) || cardNumber.startsWith("52", 0) || cardNumber.startsWith("53", 0)
      || cardNumber.startsWith("54", 0) || cardNumber.startsWith("55", 0))
    {
      $("#mastercardImage").css("opacity",1.0);
      $("#visaImage").css("opacity",0.4);
      $("#americanexpressImage").css("opacity",0.4);
      $("#discoverImage").css("opacity",0.4);
    }
    else if(cardNumber.startsWith("4", 0))
    {
      $("#visaImage").css("opacity",1.0);
      $("#mastercardImage").css("opacity",0.4);
      $("#americanexpressImage").css("opacity",0.4);
      $("#discoverImage").css("opacity",0.4);
    }
    else if(cardNumber.startsWith("34", 0) || cardNumber.startsWith("37", 0))
    {
      $("#americanexpressImage").css("opacity",1.0);
      $("#mastercardImage").css("opacity",0.4);
      $("#visaImage").css("opacity",0.4);
      $("#discoverImage").css("opacity",0.4);
  }
    else if(cardNumber.startsWith("6011", 0) || cardNumber.startsWith("622126-622925", 0)||
            cardNumber.startsWith("644-649", 0) || cardNumber.startsWith("65", 0))
    {
      $("#discoverImage").css("opacity",1.0);
      $("#mastercardImage").css("opacity",0.4);
      $("#visaImage").css("opacity",0.4);
      $("#americanexpressImage").css("opacity",0.4);
    }
  }
}



function validateForm()
{
  clearValidateErrors();
  var isValid = true;

  if($("#shipFirstName").val() == "")
  {
    isValid = false;
    $("#shipFirstNameError").html("Please enter first name.");
  }

  if($("#shipLastName").val() == "")
  {
    isValid = false;
    $("#shipLastnameError").html("Please enter last name.");
  }

  if($("#streetAddress").val() == "")
  {
    isValid = false;
    $("#addressError").html("Please enter street address.");
  }

  if($("#zipCode").val() == "")
  {
    isValid = false;
    $("#zipCodeError").html("Please enter zip code.");
  }

  if($("#city").val() == "")
  {
    isValid = false;
    $("#cityError").html("Please enter city.");
  }

  if($("#email").val() == "")
  {
    isValid = false;
    $("#emailError").html("Please enter email.");
  }

  if($("#billFirstName").val() == "")
  {
    isValid = false;
    $("#billFirstNameError").html("Please enter first name.");
  }

  if($("#billLastName").val() == "")
  {
    isValid = false;
    $("#billLastNameError").html("Please enter last name.");
  }

  if($("#cardNumber").val() == "")
  {
    isValid = false;
    $("#cardError").html("Please enter card number.");
  }

  if($("#securityCode").val() == "")
  {
    isValid = false;
    $("#securityCodeError").html("Please enter security code.");
  }

  if(isValid)
  {
    validateCreditCard();
  }

}

function validateCreditCard()
{
  cardNumber = $("#cardNumber").val();
  var sum  = 0;
  var splitCardNumber = cardNumber.split("");
  var reverseArray = splitCardNumber.reverse();

  for(var i = 1; i <= reverseArray.length; i++)
  {
    if(i%2 == 0)
    {
      var tempSum = reverseArray[i-1]*2
      if(tempSum > 9)
      {
        tempSum -= 9;
      }
      reverseArray[i-1] = tempSum;
    }
    sum += parseInt(reverseArray[i-1]);
  }
  if(sum % 10 == 0)
  {
    alert("true");
  }
  else
  {
    alert("false");
  }
}

function clearValidateErrors()
{
  $("#shipFirstNameError").html("");
  $("#shipLastnameError").html("");
  $("#addressError").html("");
  $("#zipCodeError").html("");
  $("#cityError").html("");
  $("#emailError").html("");
  $("#billFirstNameError").html("");
  $("#billLastNameError").html("");
  $("#cardError").html("");
  $("#securityCodeError").html("");

}
