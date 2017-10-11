<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body> 
    <s:form action="user_add">
    	<s:textfield name="name" label="用户名"></s:textfield>
    	<s:password name="password" label="密码"></s:password>
    	<s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
