/**
 * 
 */

$(function() {

	$("#dateId").datepicker();

	var places = [ "Nyíregyháza", "Debrecen", "Budapest" ];
	$("#birthplace").autocomplete({
		source : places
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
		if (!$("#fulln").val()) {

			$("#fullnL").addClass("warning");
			event.preventDefault();
		}
		if (!validateEmail($("#e-mail").val())) {

			$("#emailL").addClass("warning");
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

	function validateEmail(email) {
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		return re.test(email);
	}

});