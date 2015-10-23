/////////////////////////////////////////////////////////////////////////////
//

$(document).ready(function() {
	
	$(".registerLink").click( function( event ) {
		event.preventDefault();
		$(".overlay").fadeToggle("fast");
	});
	
	$(".close").click(function(){
        $(".overlay").fadeToggle("fast");
    });
	
	$("table").DataTable();
	
	$(".menu").menu();
	
});