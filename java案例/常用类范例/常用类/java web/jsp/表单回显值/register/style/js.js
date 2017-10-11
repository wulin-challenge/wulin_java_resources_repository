
$(document).ready(function(){
	
	$("form").eq(0).bind("submit",function(){
		var username=$("#username").attr("value");
		if($.trim(username)==""||$.trim(username).length==0){
			username=$("#username").attr("value","亲!用户名必填.");
			return false;
		}
		return true;SS
	});
	
	$("#queryButton").bind("click",function(){
		var queryText=$("#queryText").attr("value");
		if(queryText.match("[0-9]+")){
			var url="Register?id="+queryText;
			window.location=url;
		}else if($.trim(queryText).length==0||$.trim(queryText)==""){
			alert("亲!此处不能为空");
		}else{
			alert("亲!此处只能输入大于0的数字");
		}
	});
	
	
});