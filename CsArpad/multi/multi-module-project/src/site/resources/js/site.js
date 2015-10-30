
  $(function() {
	  $('#leftColumn').css('overflow','visible');
    $( "#navcolumn ul" ).menu({
      items: "> :not(.ui-widget-header)"
    });
  });
  
 $(document).ready(function(){
  $.each($('div.section h2'),function(key,value) {
	  console.log(key);
	  if(key > 0) {
	  $(value).insertBefore($(value).parent());
	  } else {
		  $(value).addClass("ui-accordion-header ui-state-default ui-accordion-icons ui-corner-all");
		  $(value).parent().insertBefore($(value).parent().parent());
	  }
  });
  
  $("h3").addClass("ui-accordion-header ui-state-default ui-accordion-icons ui-corner-all");
  $("#contentBox p a").parent().remove();
  $('#contentBox script').remove();
  
  $('#contentBox').accordion({
      heightStyle: "content",
	  animate:20000
    });
	
	$.each( $('tbody'), function(key,value){
		$($("tr",value)[0]).wrap(function() {
			return "<thead>" + $( this ).html() + "</thead>";
		});
		
		$($("tr",value)[0]).remove();
	});
	
	$('table').DataTable({
		jQueryUI:true
	});
	
	
 });
 

 
