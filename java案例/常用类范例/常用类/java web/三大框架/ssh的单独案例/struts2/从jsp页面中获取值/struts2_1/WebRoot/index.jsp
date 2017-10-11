<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
  <body>
   
	<form action="parameter_getValue.action" method="post">
		id:<input type="text" name="id"/><br/>
		name:<input type="text" name="name"/><br/>
		password:<input type="text" name="password"/><br/>
		happy:篮球<input type="checkbox" name="happy" value="lq"/>
		java<input type="checkbox" name="happy" value="java"/>
		台球<input type="checkbox" name="happy" value="tq"/>
		音乐<input type="checkbox" name="happy" value="yy"/><br/>
		student.Id;<input type="text" name="student.id"/><br/>
		city:<select name=city>
			<option value="cd">成都</option>
			<option value="bj">北京</option>
			<option value="sh">上海</option>
			<option value="gz">广州</option>
		</select><br/>
		<input type="submit" value="提交"/><br/>
	</form>
  </body>
</html>
