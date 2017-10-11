<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="script/js/jquery/jquery-1.7.2.min.js"></script>  
		<script type="text/javascript" src="script/js/jquery/jquery.form.js"></script>  
		<script type="text/javascript">
    $(function () {
        var options = {
            success: function (data) {
            	alert(12);
                $("#responseText").text(data);
            }
        };
 
        $("#form1").ajaxForm(options);
    });
</script>
</head>  
<body>  
	<form id="form1" action="/testUploadAndDownload/PersonAction" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>附件名字:</td>
            <td>
                <input type="text" name="fileName" /></td>
        </tr>
        <tr>
            <td>附件:</td>
            <td>
                <input type="file" name="document" /></td>
        </tr>
        <tr>
            <td colspan="2" style="align-content: center">
                <input type="submit" value="模拟iframe提交表单" />
            </td>
        </tr>
    </table>
</form>
<label id="responseText"></label>
</body>  
</html>
