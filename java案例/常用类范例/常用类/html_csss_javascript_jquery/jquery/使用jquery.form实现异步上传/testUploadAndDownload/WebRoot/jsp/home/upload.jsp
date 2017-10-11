<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="script/js/jquery/jquery-1.7.2.min.js"></script>  
		<script type="text/javascript" src="script/js/jquery/jquery.form.js"></script>  
		<script type="text/javascript">  
			$(document).ready(function(){
				$('#upload').bind('click', function(){
					alert(21);
					$('#uploadForm').ajaxForm({
						url:"/testUploadAndDownload/PersonAction",
						type:"post",  
			            enctype:'multipart/form-data',  
			            iframe: true,  
				        dataType: 'json',  
				        success:function(data, statusText) {
			                if (data.status == 200) {
			                	alert(1);
			                }else{
			                	alert(2);
			                }
						}
					});
				});
			});
	
	</script>  
</head>  
<body>  
	<form action="/testUploadAndDownload/PersonAction" id="uploadForm" method="post" enctype="multipart/form-data">  
		<input type="text" name="message" ><br/>  
		<input type="file" name="file"> <br/>  
	</form>  
	<input id ="upload" type = "button" value="上传"/>
	<hr/>  
</body>  
</html>
