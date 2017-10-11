
jQuery(function($) {
  
	$("img").bind("click",function(){
		var src=$(this).attr("src","./seat/xj1.png"); 
		var flag=$(this).unbind( "mouseout");
		
	}); 
	
	$("img").bind("dblclick",function(){
		var src=$(this).attr("src","./seat/zw.png"); 
		$("img").bind("mouseout",function(){
			var src=$(this).attr("src","./seat/zw.png"); 
		});
	}); 
	
	
	
		$("img").bind("mouseout",function(){
			var src=$(this).attr("src","./seat/zw.png"); 
		}); 
	
	$("img").bind("mouseover",function(){
		var src=$(this).attr("src","./seat/xj1.png"); 

	}); 
}); 