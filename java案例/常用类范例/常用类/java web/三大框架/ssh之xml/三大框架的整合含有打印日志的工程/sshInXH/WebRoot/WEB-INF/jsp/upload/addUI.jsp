<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body> 
    <s:form action="upload_add" enctype="multipart/form-data">
    	<s:hidden name="userId"></s:hidden>
    	<s:file name="uploadFile" label="上传文件"></s:file>
    	<s:submit value="上传"></s:submit>
    </s:form>
  </body>
</html>
