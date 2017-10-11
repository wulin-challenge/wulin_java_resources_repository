<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	
	</head>
  <body>
  	<br>
  	<a href="${pageContext.request.contextPath}/PersonAction">显示</a>
  	<table border = "1px" style="border-collapse:collapse;">
  		<caption>要导出的表格word</caption>
  		<tr>
  			<th>编号</th>
  			<th>姓名</th>
  			<th>年龄</th>
  			<th>性别</th>
  			<th>体重</th>
  			<th>升高</th>
  		</tr>
	    <c:forEach var="person" items="${personList}">
		    <tr>
	  			<td>${person.personId}</td>
	  			<td>${person.username}</td>
	  			<td>${person.age}&nbsp;岁</td>
	  			<td>${person.denger}</td>
	  			<td>${person.weight}&nbsp;kg</td>
	  			<td>${person.height}&nbsp;cm</td>
	  		</tr>
	    </c:forEach>
    </table>
    <form action="${pageContext.request.contextPath}/PersonAction" method="POST" enctype="multipart/form-data">
    	<table border="1px" style = "border-collapse:collapse">
    		<caption>上传相片</caption>
    		<tr>
	    		<td>
					 <div style="height:120px;width:100px;border:solid 1px red;text-align:center;line-height:25px;padding:40px 0px 0px 0px">
				         <input name = "parameter" type="file" style="position:absolute;z-index:0;height:120px;width:100px;opacity:0;filter:alpha(opacity=0);cursor:pointer;" />    
				         <span style = "color:green;">上传本人近期1寸白底彩照1份</span>
					</div>	
				</td>
			</tr>
			<tr>
				<td><input type = "submit" value = "上传"/></td>
			</tr>
		</table>
	</form>
  </body>
</html>
