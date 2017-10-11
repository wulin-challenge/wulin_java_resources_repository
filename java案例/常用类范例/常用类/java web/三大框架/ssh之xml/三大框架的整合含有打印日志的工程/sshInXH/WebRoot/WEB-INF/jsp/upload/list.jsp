<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body> 
   
    	<table border="1" align="center" style="border-collapse:collapse">
    		<caption>下载列表 </caption>
    		<tr>
    			<th>图片</th>
    			<th>用户</th>
    			<th>操作</th>
    		</tr>
    		 <s:iterator value="#uploadList">
    		 	<tr>
    		 		<td><img style="width:80px;height:80px;" src="${pageContext.request.contextPath}${filePath}"/></td>
    		 		<td style="width:80px;" align="center">${user.name}</td>
    		 		<td style="width:80px;" align="center"><s:a action="upload_getDownloadFile?id=%{id}">下载</s:a></td>
    		 	</tr>
    		 </s:iterator>
    	</table>
    
  </body>
</html>
