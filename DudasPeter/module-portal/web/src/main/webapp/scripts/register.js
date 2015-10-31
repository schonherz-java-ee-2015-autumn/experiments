/**
 * 
 */
function invalidate(obj, isInvalid) {
	if(isInvalid) {
		obj.addClass("invalid");
	} else {
		obj.removeClass("invalid");
	}
}

function checkUserName() {
	$.ajax({
		method : "POST",
		url : "CheckUserNameAjax",
		data : {username : $("#username").val()},
		dataType : "json",
		success : function(data) {

			invalidate($("input#username"), data.result !== "SUCCESS");

		},
		error : function(e) {
			console.log(e);
		}
	});
}

function checkPasswords() {
	var pass1 = $("#password");
	var pass2 = $("#password2");
	var isItOK = pass1.val() !== pass2.val();
	
	invalidate(pass1, isItOK);
	invalidate(pass2, isItOK);
}

$(document).ready(function(){
	$("#username").blur(function() {
		checkUserName();
		});
	
	$("#password").on("input" ,function() {
		checkPasswords();
	});
	
	$("#password2").on("input" ,function() {
		checkPasswords();
	});
	
	$("#dob").datepicker();
	$("#dob").datepicker("option", "dateFormat", "yy-mm-dd");
});