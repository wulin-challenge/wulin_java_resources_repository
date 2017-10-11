<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body> 
    	<table align="center" border="1" style="border-collapse : collapse">
    		<caption>用户列表</caption>
    		<tr>
    			<th>编号</th>
    			<th>用户名</th>
    			<th>密码</th>
    			<th>操作</th>
    		</tr>
    		<s:iterator value="#userList">
	    		<tr>
	    			<td>${id}</td>
	    			<td>${name}</td>
	    			<td>${password}</td>
	    			<td>
	    				<s:a action="user_editUI?id=%{id}">修改</s:a>
	    				<s:a action="user_delete?id=%{id}">删除</s:a>
	    			</td>
	    		</tr>
    		</s:iterator>
    	</table>
  </body>
</html>
