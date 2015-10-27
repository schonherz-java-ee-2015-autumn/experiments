
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
	
	$.each( $('link'), function(key,value){
		var href = $(value).attr("href");
		if(href.indexOf('smoothness') > 0) {
			$(value).attr("href",href.replace("smoothness","start"));
		}
	});
	
	$('.xright').html('<input type="radio" id="radio1" name="radio"><label for="radio1">Smoothness</label> <input type="radio" id="radio2" name="radio" checked="checked"><label for="radio2">Start</label>');
	$(".xright").buttonset();
	
	function replaceStyle(fromv,tov) {
		$.each( $('link'), function(key,value){
		var href = $(value).attr("href");
		if(href.indexOf(fromv) > 0) {
			$(value).attr("href",href.replace(fromv,tov));
		}
	});
	}
	
	$("#radio1").click(function(){
		replaceStyle('start','smoothness');
	});
	
	
	$("#radio2").click(function(){
		replaceStyle('smoothness','start');
	});
 });
 

 
