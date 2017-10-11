<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="cn.scxh.model.User"%>
<%@page import="java.util.List"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'query.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <%
    	User user1 = (User)request.getAttribute("user");
    	String id = "";
    	if(user1 != null && user1.getId() !=0){
    		id = user1.getId() + "";
    	}
    	String name = "";
    	if(user1 != null && user1.getName()!= null){
    	
    		name = user1.getName();
    	}
     %>
  	<form action="query" method="post"> 
  		编号:<input type="text" name="id" value="<%=id %>">
  		姓名:<input type="text" name="name" value="<%=name%>">
  		<input type="submit" id="b1" value="搜索">
  	</form>
  
    <%
    	List<User> userList = (List<User>)request.getAttribute("users");
     %>
     <table>
     	<tr>
     		<td>编号</td>
     		<td>姓名</td>
     		<td>性别</td>
     		<td>爱好</td>
     		<td>部门</td>
     		<td>出生日期</td>
     		<td>操作</td>
     	</tr>
     <%
     	for(int i=0;i<userList.size();i++){
     		User user = userList.get(i);
     %>	
     	<tr>
     		<td><%=user.getId() %></td>
     		<td><%=user.getName() %></td>
     		<td><%=user.getSex() %></td>
     		<td><%=user.getHobby() %></td>
     		<td><%=user.getDept() %></td>
     		<td><%=user.getBirthday() %></td>
     		<td><a href="preUpdateServlet?id=<%=user.getId()%>">修改</a></td>
     	</tr>
     <%	
     	}
      %>
     	
     	
     </table>
  </body>
</html>
