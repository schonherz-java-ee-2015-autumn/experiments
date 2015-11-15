$(document).on('click', '#buttonSignIn', function(event) {
	validate();
});

$.validator.addMethod('regex', function(value, element, param) {
	return param.test(value);

},

'Invalid format!');

function validate() {
	$('#signInForm')
			.validate(
					{
						rules : {
							userName : {
								required : true,
								minlength : 4,
								maxlength : 10,
								regex : /^[a-zA-z0-9_-]+$/
							},
							password : {
								required : true,
								minlength : 4,
								maxlength : 50,
								regex : /^[a-zA-z0-9_-]+$/
							}

						},
						messages : {
							userName : {
								required : "You must enter your user name!",
								minlength : "Too short user name. Min. length is 4 charachter!",
								maxlength : "Too long user name. Max. length is 10 charachter!"
							},
							password : {
								required : "You must enter a valid password!",
								minlength : "Too short password. Min. length is 4 charachter!",
								maxlength : "Too long password. Max. length is 50 charachter!"
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
