<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>login</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/js/jquery-1.2.6.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/js/myJs.js"></script>
  </head>
  
  <body>
	  <form action="${pageContext.request.contextPath}/BooksServlet?judge=login" method="post">
		  	<table>
		  		<caption>login</caption>
		  		<tr>
		  			<th>用户名</th>
		  			<td><input id="username" type="text" name="username"/></td>
		  			
		  		</tr>
		  		<tr>
		  			<th>密码</th>
		  			<td><input id="password" type="password" name="password"/></td>
		  		</tr>
		  		<tr>
		  			<td><input type="submit" value="提交"/></td>
		  		</tr>
		  	</table>
	  	</form>
  </body>
</html>
