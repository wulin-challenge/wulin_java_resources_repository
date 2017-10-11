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
    <base href="<%=basePath%>">
    
    <title>My JSP 'query.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%
  		User user = (User)request.getAttribute("user");
   %>
	<script type="text/javascript" src="js/jquery-1.2.6.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var sex = "<%=user.getSex()%>";
			$("input[name=sex][value="+sex+"]").attr("checked","true");
			var dept = "<%=user.getDept()%>";
			$("select[name=dept] option[value="+dept+"]").attr("selected","true");
			var hobby = "<%=user.getHobby()%>";
			$("input[name=hobby]").each(function(){
				var t =$(this).val();
				if(hobby.indexOf(t) !=-1){
					$(this).attr("checked","true");
				}
			});
		});
	</script>
  </head>
  
  <body>
  
    <form action="add" method="get">
    	<input type="hidden" name="id" value="<%=user.getId() %>">
			<table>
				<tr>
					<td>
						姓名
					</td>
					<td>
						<input type="text" name="username" value="<%=user.getName() %>">
					</td>
				</tr>
				<tr>
					<td>
						性别
					</td>
					<td>
						男<input type="radio" value="00" name="sex">
						女<input type="radio" value="01" name="sex">
					</td>
				</tr>
				<tr>
					<td>
						部门
					</td>
					<td>
						<select name="dept">
							<option value="00">市场部</option>
							<option value="01">研发部</option>
							<option value="02">财务部</option>
							<option value="03">人力资源部</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						出生日期
					</td>
					<td>
						<input type="text" name="birthday" maxlength="100" id="Txt_CreateDateST03"  onclick="SelectDate(this,'yyyy-MM-dd')" readonly="true" style="width:200px;cursor:pointer" /><br />         
					</td>
				</tr>
				<tr>
					<td>
						个人特长
					</td>
					<td>
						篮球<input type="checkbox" value="00" name="hobby">
						足球<input type="checkbox" value="01" name="hobby">
						乒乓球<input type="checkbox" value="02" name="hobby">
						高尔夫<input type="checkbox" value="03" name="hobby">
					</td>
				</tr>
				<tr>
					<td>
						个人说明
					</td>
					<td>
						<textarea  name="description"><%=user.getDescription() %></textarea>
					</td>
				</tr>
				<tr>
					<td>
						个人头像
					</td>
					<td>
						<input type="file" name="img">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="保存">
					</td>
					
				</tr>
			</table>
		</form>
  </body>
</html>
