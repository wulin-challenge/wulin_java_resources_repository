<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  <body>
	<select id="provinceID">
		<option>选择省份</option>	
		<option>吉林省</option>	
		<option>辽宁省</option>	
		<option>山东省</option>	
		<option>湖南省</option>	
	</select>
	<select id="cityID">
		<option>选择城市</option>	
	</select>
	<script type="text/javascript">
		document.getElementById("provinceID").onchange=function(){
			//清空原city列表框
			var citySelectElement = document.getElementById("cityID");
			var cityElementArray = citySelectElement.options;
			var size = cityElementArray.length;
			if(size > 1){
				for(var i=size-1;i>0;i--){
					citySelectElement.removeChild(cityElementArray[i]);
				}
			}
			var province = this[this.selectedIndex].innerHTML;
			province = encodeURI(province);
			var xhr = createXHR();
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
					
						//取得json字符串
						var jsonString = xhr.responseText;
						
						//将json字符串转成json对象						
						var jsonObject = eval("("+jsonString+")");
									
						var size = jsonObject.length;
						
						for(var i=0;i<size;i++){
							
							var city = jsonObject[i].city_name;
							
							var optionElement = document.createElement("option");
							
							optionElement.innerHTML = city;
							
							document.getElementById("cityID").appendChild(optionElement);
							
						}
						
					
					
					
					
					
						/*
						var xmlDocument = xhr.responseXML;
						var cityElementArray = xmlDocument.getElementsByTagName("city");
						size = cityElementArray.length;
						for(var i=0;i<size;i++){
							var city = cityElementArray[i].firstChild.nodeValue;
							var optionElement = document.createElement("option");
							optionElement.innerHTML = city;
							document.getElementById("cityID").appendChild(optionElement);
						}
						*/
					}
				}
			}
			xhr.open("get","/day31/CityServlet?time="+new Date().getTime()+"&province="+province);
			xhr.send(null);
		};
		function createXHR(){
			var xhr = null;
			if(window.ActiveXObject){
				xhr = new ActiveXObject("microsoft.xmlhttp");
			}else{
				xhr = new XMLHttpRequest();
			}
			return xhr;
		}
	</script>
  </body>
</html>



