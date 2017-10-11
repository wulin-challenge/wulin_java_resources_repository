<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    	<ul>
    		<li>访问值栈中的属性:<s:property value="username"/></li>
    		<li>访问方法:<s:property value="user.username"/></li>
    		<li>访问普通属性:<s:property value="user.address.city"/></li>
    		<li>访问普通方法:<s:property value="m()"/></li>
    		<hr>
    		<li>访问静态方法:<s:property value="@cn.scxh.action.Test@m()"/></li>
    		<li>访问静态属性:<s:property value="@cn.scxh.action.Test@str"/></li>
    		<li>访问Math类的静态方法:<s:property value="@@max(6,5)"/></li>
    		<hr>
    		<li>访问构造方法:<s:property value="new cn.scxh.action.User('sdfsfd')"/></li>
    		
    		<hr/>
    		<li>访问List:<s:property value="userList"/></li>
    		<li>访问List元素:<s:property value="userList[0].username"/></li>
    		<li>访问List中元素的集合:<s:property value="userList.{password}[0]"/></li>
    		
    		<hr>
    		<li>访问map:<s:property value="map"/></li>
    		<li>访问map的某个元素:<s:property value="map.cc"/>||<s:property value="map['cc']"/>||<s:property value="map[\"cc\"]"/></li>
    		<li>访问map的所有key:<s:property value="map.keys"/></li>
    		<li>访问map的所有value:<s:property value="map.values"/></li>
    		<li>访问容器大小:<s:property value="map.size"/></li>
    		<hr>
    		<li>过滤:<s:property value="userList.{?#this.password=='222'}[0].username"/></li>
    		<li>过滤:<s:property value="userList.{^#this.age>10}.{username}"/></li>
    		<li>过滤:<s:property value="userList.{$#this.age>10}.{username}"/></li>
    	<s:debug></s:debug>
    		
    		<hr>
    		property:<s:property value="zhangsan" default="旺才"/><br>
    		<s:set var="username" value="username" ></s:set>
    		request:<s:property value="#request.username"/>
    		ActionContext:<s:property value="#username"/>
    		
    		<hr>
    		iterator:<s:iterator value="{2,3,4}">
    				<s:property/>
    			</s:iterator>
    			
    			iterator1:<s:iterator value="userList">
    				<s:property value="username"/>
    			</s:iterator>
    			
    			<s:iterator value="{'aaa','bbb','ccc'}" status="status">
    				<s:property/><br>
    				遍历过的元素总数:<s:property value="#status.count"/>
    				遍历过的元素索引:<s:property value="#status.index"/>
    				当前是偶数:<s:property value="#status.even"/>
    				当前是奇数:<s:property value="#status.odd"/>
    				是第一个元素吗:<s:property value="#status.first"/>
    				是最后一个元素吗:<s:property value="#status.last"/>
    				
    			
    			</s:iterator>
    			<br>
    			<s:iterator value="#{1:'a',2:'c',3:'b'}" var="x">
    				<s:property value="#x.key"/>----><s:property value="#x.value"/><br>
    			</s:iterator>
    	</ul>

    	<s:form>
    		<s:textfield></s:textfield>
    	</s:form>
    	
  </body>
</html>
