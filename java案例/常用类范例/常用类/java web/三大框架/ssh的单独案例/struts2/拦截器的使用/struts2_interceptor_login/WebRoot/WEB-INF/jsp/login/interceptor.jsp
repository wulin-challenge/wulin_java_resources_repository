<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <body>
   拦截成功${user.username}
   <s:form action="various_getValue">
	  <s:select  name="myList" list="myList"></s:select>
	  <s:select name="myMap" list="#myMap"></s:select>
	  <s:submit value="提交"></s:submit>
  </s:form>
  <s:form action="upload_upload" method="post" enctype="multipart/form-data">
  	<s:file name="upload"></s:file>
  	<s:submit value="上传"></s:submit>
  </s:form>
  <a href="download_getDownloadFile.action">下载</a>
  </body>
</html>
