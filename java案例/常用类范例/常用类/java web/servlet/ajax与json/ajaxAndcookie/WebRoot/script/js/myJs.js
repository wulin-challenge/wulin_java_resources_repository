$(document).ready(function(){
	$("#button").bind("click",function(){
		$.ajax({
			   type: "POST",
			   url:"/ajaxAndcookie/CookieServlet",
			   data:"judge=login",
			   dataType: "json",
			   success: function(msg){
				alert(msg[0].name);
			    $.each(msg,function(i,student){
			    	alert(student.id+"="+student.name);
			    });
			     
			   }
			}); 
	});
}); 
