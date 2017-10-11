$(document).ready(function(){
	$("#button").bind("click",function(){
		$.ajax({
			   type: "POST",
			   url:"/MyFilter/BooksServlet",
			   data:"judge=login",
			   success: function(msg){
					alert(msg);
			   }
			}); 
	});
}); 
