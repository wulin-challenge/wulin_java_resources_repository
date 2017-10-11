<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/primary/common/common.jsp" %>
	</head>
	<body id="myFirstPageLayout" class="easyui-layout">
		<div id="firstPageNorth" region="north" border="false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
		<div id="firstPageWest" region="west" split="true" title="West" style="width:200px;padding:10px;">
			<input id="westLeft" type="hidden" name="westLeft">
		</div>
		
		<div id="firstPageEast" region="east" split="true" collapsed="true" title="East" style="width:100px;padding:10px;">east region</div>
		<div id="firstPageSouth" region="south" border="false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
		<div id="firstPageCenter" region="center" title="Main Title">
			<div class="easyui-tabs" fit="true" border="false">
			<div title="Tab1" style="padding:20px;overflow:hidden;"> 
				<div style="margin-top:20px;">
					<h3>jQuery EasyUI framework help you build your web page easily.</h3>
					<li>easyui is a collection of user-interface plugin based on jQuery.</li> 
					<li>using easyui you don't write many javascript code, instead you defines user-interface by writing some HTML markup.</li> 
					<li>easyui is very easy but powerful.</li> 
				</div>
			</div>
			<div id="tab2" title="Tab2" closable="true" style="padding:20px;">This is Tab2 width close button.
			
			</div>
			<div title="Tab3" iconCls="icon-reload" closable="true" style="overflow:hidden;padding:5px;">
				<table id="tt2"></table> 
			</div>
		</div>
		</div>
</body>
</html>