/**
 * 
 */

$(function() {

	$("#dateId").datepicker();

	var places = [ "Nyíregyháza", "Debrecen", "Budapest" ];
	$("#birthplace").autocomplete({
		source : places
	});

	$("#user").keyup(function(event) {
		userChecker();
	}).focus(function(event) {
		userChecker();
	}).focusout(function(event) {
		userChecker();
	});

	$("#e-mail").keyup(function(event) {
		eMailChecker();
	}).focus(function(event) {
		eMailChecker();
	}).focusout(function(event) {
		eMailChecker();
	});

	$("input[type=submit]").button();
	$("#toLogin").button();
	$("#toRegistration").button();
	$("#toUsers").button();

	$("form").submit(function(event) {

		if (!$("#user").val() || checkUser($("#user").val()) == "true") {
			$("#userL").addClass("warning");
			event.preventDefault();
		}
		if (!$("#passw").val()) {

			$("#passwL").addClass("warning");
			event.preventDefault();
		}
		if (!$("#passwre").val()) {

			$("#passwreL").addClass("warning");
			event.preventDefault();
		}
		if (!$("#fulln").val()) {

			$("#fullnL").addClass("warning");
			event.preventDefault();
		}
		if (!validateEmail($("#e-mail").val())) {

			$("#emailL").addClass("warning");
			event.preventDefault();
		}

		var a = $("#passw").val();
		var b = $("#passwre").val();
		if (a != b) {

			$("#passwL").addClass("warning");
			$("#passwreL").addClass("warning");
			event.preventDefault();
		}

		var d = validateDate($("#dateId").val(), "MM/dd/yyyy");

		if (d != "true") {
			$('#dateIdL').addClass('warning');
			event.preventDefault();
		} else {
			$('#dateIdL').removeClass('warning');
		}

	});

	var tooltips = $("[title]").tooltip({
		position : {
			my : "left top",
			at : "right+5 top-5"
		}
	});

	function validateEmail(email) {
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		return re.test(email);
	}

});