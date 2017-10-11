<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	输入用户名：<input type="text"/>单击检查按钮后，立即查检结果
  	<input type="button" value="检查"/>
  	<hr/>
  	<div>
  		<!-- 显示结果 -->
  	</div>
  	<script type="text/javascript">
  		document.getElementsByTagName("input")[1].onclick=function(){
  			//取得用户输入的用户名
  			var username = document.getElementsByTagName("input")[0].value;
  			//对中文编码
  			username = encodeURI(username);
  			//创建AJAX引警对象
  			var xhr = createXHR();
  			//设置函数监听
  			xhr.onreadystatechange = function(){
  				if(xhr.readyState==4){
  					if(xhr.status==200){
  						//以字符串形式接收
  						//var msg = xhr.responseText;
  						
  						//以XML形式接收
  						var xmlDocument = xhr.responseXML;
  						var resElement = xmlDocument.getElementsByTagName("res")[0];
 						var msg = resElement.firstChild.nodeValue;			
  						var divElement = document.getElementsByTagName("div")[0];
  						divElement.innerHTML = "<img src='"+msg+"'/>";
  					}
  				}
  			}
			
			//准备以POST方式发送请求
			xhr.open("post","/day31/PostServlet?time="+new Date().getTime());
			
			//设置请求头，只有是POST方式下，才设置该请求头
			xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
			
			//真正发送请求
			xhr.send("username="+username);
  		}
  		function createXHR(){
  			var xhr = null;
  			try{
  				xhr = new ActiveXObject("microsoft.xmlhttp");
  			}catch(e){
  				try{
  					xhr = new XMLHttpRequest();
  				}catch(e){
  					window.alert("你的浏览器太差");
  				}
  			}
  			return xhr;
  		}
  	</script>
  </body>
</html>
