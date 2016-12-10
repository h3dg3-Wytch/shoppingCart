$(function() {
  $("form[name='registrationForm']").validate({
    // Specify validation rules
    rules: {
      // left side = name attribute; right side = validation rule
      firstName: "required",
      lastName: "required",
      userName: "required",
      firstPassword: {
        required: true,
        minlength: 5
      },
      secondPassword: {
        minlength: 5,
        equalTo:"#firstPassword"
      }
    },
    messages: {
      firstName: "Please enter your First Name<br>",
      lastName: "Please enter your Last Name<br>",
      firstPassword: {
        required: "Please provide a Password<br>",
        minlength: "This must be at least 5 characters long<br>"
      },
      secondPassword: {
        minlength: "This must be at least 5 characters long<br>",
        equalTo: "Passwords do not match<br>"
      },
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
});
