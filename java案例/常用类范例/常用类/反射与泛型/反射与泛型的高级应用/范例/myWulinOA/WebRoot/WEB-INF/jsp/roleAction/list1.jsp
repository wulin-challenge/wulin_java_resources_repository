<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<body>
		<s:iterator value="roleList">
			<s:property value="id"/>
			<s:property value="name"/>
			
			<s:a action="roleAction_delete" onclick="return confirm('确定删除?')">
				<s:param name="id" value="%{id}"></s:param>
				删除
			</s:a><br/>
		</s:iterator>
	</body>
</html>
