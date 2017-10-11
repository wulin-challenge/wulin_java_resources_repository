<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>注册</title>
		<script type="text/javascript" src="./style/jquery-1.2.6.min.js"></script>
		<script type="text/javascript" src="./style/js.js"></script>
		<link rel="stylesheet" type="text/css" href="./style/css.css"/>
	</head>
	<body> 
		<div>
		<div id="queryDiv">
			<input id="queryText" type="text"/>
			<input id="queryButton" type="button" value="查找"/>
		</div>
			<form action="Register" method="post">
				<table align="center" border="1">
					<caption>注册表单</caption>
					<tr>
						<th>用户名</th>
						<td><input id="username" type="text" name="username" value="${person.username}"/></td>
					</tr>
					<tr>
						<th>密码</th>
						<td><input type="password" name="password"/ value="${person.password}"></td>
					</tr>
					<tr>
						<th>性别</th>
						<td><input type="radio" name="gender" value="11" ${person.gender=="11"?'checked': ""} />男
						<input type="radio" name="gender" value="10" ${person.gender=="10"?'checked': ""}/>女</td>
					</tr>
					<tr>
						<th>爱好</th>
						<td><input type="checkbox" name="happy" value="lq" ${person.happy=="lq"?"checked" : ""}/>篮球
							<input type="checkbox" name="happy" value="tq" ${person.happy=="tq"?"checked" : ""}/>篮球
							<input type="checkbox" name="happy" value="jv" ${person.happy=="jv"?"checked" : ""}/>java
							<input type="checkbox" name="happy" value="yy" ${person.happy=="yy"?"checked" : ""}/>音乐
						
						</td>
					</tr>
					<tr>
						<th>城市</th>
						<td>
							<select id="city" name="city">
								<option value="bj" ${person.city=="bj"?"selected": ""}>北京</option>
								<option value="cd" ${person.city=="cd"?"selected": ""}>成都</option>
								<option value="sh" ${person.city=="sh"?"selected": ""}>上海</option>
								<option value="gz" ${person.city=="gz"?"selected": ""}>广州</option>
								<option value="sz" ${person.city=="sz"?"selected": ""}>深圳</option>
							</select>
						
						</td>
					</tr>
					<tr>
						<th>简介</th>
						<td><textarea name="introduce">${person.introduce}</textarea></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" value="提交"/></td>
					</tr>
				</table>
			</form>
		<div>
	</body>
</html>