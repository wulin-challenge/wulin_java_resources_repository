
jQuery(function($) {

	var queryValue=$("#queryNode").bind("keyup",function(){
		var value1=queryValue.attr("value");
		var object=$(".classtr:contains("+value1+")");
		for(var i=0;i<$(".classtr").length;i++){
			$(".classtr")[i].style.display="none";
		}
		for(var i=0;i<object.length;i++){
			var context1=object[i].style.display="block";
			
		}
		
	});

	var trs=$(".classtr").bind("click",function(){
		var box1=$(this).children().eq(0).children().eq(0);
			var flag=box1.attr("checked");
			if(flag){
				box1.attr("checked",false);
			}else{
				box1.attr("checked",true);
			}
	});


	
	$(".selectBox").eq(1).bind("click",function(){
		var box=$(".classCheckBox");
		for(var i=0;i<box.length;i++){
			var flag=box.eq(i).attr("checked");
			if(flag){
				box.eq(i).attr("checked",false);
			}else{
				box.eq(i).attr("checked",true);
			}
			
		}
		
	});
	
	$(".selectBox").eq(0).bind("click",function(){	
		var is=$(this).attr("checked");
		if(is){
			$(".classCheckBox").attr("checked",true);
		}else{
			$(".classCheckBox").attr("checked",false);
		}
	});


	$(".classtr").bind("mouseover",function(){
		
		$(this).css("backgroundColor","#CC33FF");
	
	});
	
	$(".classtr").bind("mouseout",function(){
			
		var trs=$(".classtr");
		for(var i=0;i<=trs.length;i++){
			if(i%2==0){
				trs.eq(i).css("backgroundColor","#66CCCC");
			}else{
				trs.eq(i).css("backgroundColor","#99FFFF");
			}
		}
	});
}); 


jQuery(function($) {
	var trs=$(".classtr");
	for(var i=0;i<=trs.length;i++){
		if(i%2==0){
			trs.eq(i).css("backgroundColor","#66CCCC");
		}else{
			trs.eq(i).css("backgroundColor","#99FFFF");
		}
	}
}); 