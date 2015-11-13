$(document).on('click', '#buttonSignUp', function(event) {
	validate();
});

$.validator.addMethod('regex', function(value, element, param) {
	return param.test(value);

},

'Invalid format!');

$.validator.addMethod('isSelected', function(value, element, param) {
	if (value == '0')
		return false;
	else
		return true;

},

'Select something');

function validate() {
	$('#signUpForm')
			.validate(
					{
						rules : {
							userName : {
								required : true,
								minlength : 4,
								maxlength : 10,
								regex : /^[a-zA-z0-9_-]+$/
							},
							firstName : {
								required : true,
								minlength : 1,
								maxlength : 50,
								regex : /^[a-zA-z ]+$/
							},
							lastName : {
								required : true,
								minlength : 1,
								maxlength : 50,
								regex : /^[a-zA-z ]+$/
							},
							email : {
								required : true,
								minlength : 4,
								maxlength : 50,
								regex : /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)+$/
							},
							phone : {
								required : true,
								minlength : 1,
								maxlength : 20,
								regex : /[0-9 -()+]+$/
							},
							location : {
								required : true,
								minlength : 1,
								maxlength : 50,
								regex : /^[a-zA-z0-9-]+$/
							},
							password : {
								required : true,
								minlength : 4,
								maxlength : 50,
								regex : /^[a-zA-z0-9_-]+$/
							},
							confirmPassword : {
								required : true,
								minlength : 4,
								maxlength : 50,
								regex : /^[a-zA-z0-9_-]+$/,
								equalTo : "#password"
							},
							gender : {
								isSelected : true
							},
							year : {
								isSelected : true
							},
							month : {
								isSelected : true
							},
							day : {
								isSelected : true
							}

						},
						messages : {
							userName : {
								required : "You must enter your user name!",
								minlength : "Too short user name. Min. length is 4 charachter!",
								maxlength : "Too long user name. Max. length is 10 charachter!"
							},
							firstName : {
								required : "You must enter your first name!",
								minlength : "Too short first name. Min. length is 1 charachter!",
								maxlength : "Too long first name. Max. length is 50 charachter!"

							},
							lastName : {
								required : "You must enter your last name!",
								minlength : "Too short first name. Min. length is 1 charachter!",
								maxlength : "Too long first name. Max. length is 50 charachter!"
							},
							email : {
								required : "You must enter a valid email!",
								minlength : "You must enter a valid email!",
								maxlength : "Too long email. Max. length is 50 charachter!"
							},
							phone : {
								required : "You must enter your phone number!",
								minlength : "Too short phone number. Min. length is 1 charachter!",
								maxlength : "Too long phone name. Max. length is 20 charachter!"
							},
							location : {
								required : "You must enter your location!",
								minlength : "Too short location name. Min. length is 1 charachter!",
								maxlength : "Too long location. Max. length is 50 charachter!"
							},
							password : {
								required : "You must enter a valid password!",
								minlength : "Too short password. Min. length is 4 charachter!",
								maxlength : "Too long password. Max. length is 50 charachter!"
							},
							confirmPassword : {
								required : "You must enter a valid password confirmation!",
								minlength : "Too short password. Min. length is 4 charachter!",
								maxlength : "Too long password. Max. length is 50 charachter!",
								equalTo : "Password does not match!"
							}

						},
						errorElement : "div",
						wrapper : "div", // a wrapper around the error
						// message
						errorPlacement : function(error, element) {
							offset = element.offset();
							error.insertBefore(element)
							error.addClass('message'); // add a class to the
							// wrapper
							error.css('position', 'absolute');
							error.css('left', offset.left
									+ element.outerWidth());
							error.css('top', offset.top);

						}

					});
}
