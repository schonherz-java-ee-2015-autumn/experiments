/**
 * 
 */
$(function() {

	$("#date").datepicker();
	$("#sendform").button();
	$("#sendformreglist").button();
	
	$("#registrationform").submit(
			function(event) {
				if (!$("#user").val()) {
					$("#userL").addClass("warning");
					event.preventDefault();
				} else {
					$('#userL').removeClass('warning');
				}
				if (!$("#password").val()
						|| $("#password").val() != $("#password2").val()) {
					$("#passwordL").addClass("warning");
					$("#password2L").addClass("warning");
					event.preventDefault();
				} else {
					$('#passwordL').removeClass('warning');
					$('#password2L').removeClass('warning');
				}
				if (!$("#email").val()) {
					$("#emailL").addClass("warning");
					event.preventDefault();
				} else {
					$('#emailL').removeClass('warning');
				}
				if (!$("#date").val()) {
					$("#dateL").addClass("warning");
					event.preventDefault();
				} else {
					$('#dateL').removeClass('warning');
				}
			});
});