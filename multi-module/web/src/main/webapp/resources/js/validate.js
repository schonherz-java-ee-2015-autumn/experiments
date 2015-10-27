  $( "form" ).submit(function( event ) {
    		  
    	  var d = validateDate($("#dateId").val(),"MM/dd/yyyy");
    	  
    	  if(d != "true") {
   	 		 $('#dateIdL').addClass('warning');   
   	 		  event.preventDefault();   	 		  
   	 	  } else {
   	 		 $('#dateIdL').removeClass('warning');  
   	 	  }
    
    	});
    
   
  function validateDate(inputDate,inputDateFormat) {
		var reValue = 0;
		$.ajax({
			url : 'ValidateDate',
			method : "POST",
			data : {
				date : inputDate,
				dateFormat : inputDateFormat
			},
			success : function(data) {
				reValue = data;
			},
			error : function(data) {
				reValue = data;
			},
			dataType : "html",
			async:false
		});
		return reValue;
	}
   
