<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	 <script type="text/javascript" src="../js/jquery-1.6.js"></script>
  </head>
  <body>
  	<select id="provinceID">
  		<option>选择省份</option>
  		<option value="gd">广东</option>
  		<option value="hn">湖南</option>
  	</select>
  	<hr>
  	<select id="cityID">
  		<option>选择城市</option>
		<!-- 动态添加城市 -->
  	</select>
  	<hr>
  	<select id="areaID">
  		<option>选择区域</option>
		<!-- 动态添加区域 -->
  	</select>
	<hr/>
  	<script type="text/javascript">
  		//省份->城市
		$("#provinceID").change(function(){
			//删除原"城市"下位框中的内容
			$("#cityID").empty();
			$("#cityID").append($("<option></option>").text("选择城市"));
			//删除原"区域"下位框中的内容		
			$("#areaID").empty();
			$("#areaID").append($("<option></option>").text("选择区域"));
			//取得选中的省份value值	
			var province = $("#provinceID option:selected").val();
			var url = "/day33/DynaServlet?time="+new Date().getTime();
			var sendData = {province:province};
			var xhr = $.post(url,sendData,function(){
				var jsonString = xhr.responseText;
				var json = eval("("+jsonString+")");
				for(var i=0;i<json.city.length;i++){
					$option = $("<option></option>").text(json.city[i]);
					$("#cityID").append($option);
				}		
			})
		});
		//城市->区域
  		$("#cityID").change(function(){
			//删除原"区域"下位框中的内容		
			$("#areaID").empty();
			$("#areaID").append($("<option></option>").text("选择区域"));
			//取得选中的城市显示值
			var city = $("#cityID option:selected").text();
			var url = "/day33/DynaServlet?time="+new Date().getTime();
			var sendData = {city:city};
			var xhr = $.post(url,sendData,function(){
				var jsonString = xhr.responseText;
				var json = eval("("+jsonString+")");
				for(var i=0;i<json.area.length;i++){
					$option = $("<option></option>").text(json.area[i]);
					$("#areaID").append($option);
				}	
			});
  		});
  	</script>
  </body>
</html>
