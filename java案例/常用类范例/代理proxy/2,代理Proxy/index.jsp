<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	<form action="${pageContext.request.contextPath}/GetPostServlet" method="get">
  		用户名：<input type="text" name="username"/>
  		<input type="submit" value="提交"/>
  	</form>
  </body>
</html>
