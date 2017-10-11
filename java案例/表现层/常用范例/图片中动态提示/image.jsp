<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	<img height="120px" src="images/lb.jpg" value="1"/>
  	<img height="120px" src="images/sq.jpg" value="2"/>
  	<div style="border-style:dotted;width:100px;position:absolute;left:350px;top:30px">
		编号：<span><!-- 动态添加编号 --></span><br/>
		名称：<span></span><br/>
		作者：<span></span><br/>  	
  	</div>
  	<script type="text/javascript">
  		//当页面被加载时，将<div>隐蔽
  		window.onload=function(){
  			//定位<div>标签
  			var divElement = document.getElementsByTagName("div")[0];
  			//通过JS操作CSS样式
  			divElement.style.visibility="hidden";
  		}
  		var imgElementArray = document.getElementsByTagName("img");
  		var size = imgElementArray.length;
  		for(var i=0;i<size;i++){
  			//鼠标移出
  			imgElementArray[i].onmouseout=function(){
  				var divElement = document.getElementsByTagName("div")[0];
  				divElement.style.visibility="hidden";
  			}
  			//鼠标移入
  			imgElementArray[i].onmouseover=function(){
  				//记录鼠标的X,Y座标
  				var x = event.clientX + 20;
  				var y = event.clientY + 40;
  				var id = this.value;
  				var xhr = createXHR();
				xhr.onreadystatechange = function(){
					if(xhr.readyState == 4){
						if(xhr.status == 200){
							//从Ajax引擎中取得json格式的字符串
							var jsonString = xhr.responseText;
							//将json格式的字符串转成json对象
							var jsonObject = eval("("+jsonString+")");
							var id = jsonObject[0].id;
							var name = jsonObject[0].name;
							var author = jsonObject[0].author;
							//在x,y座标的地方显示出来
							var divElement = document.getElementsByTagName("div")[0];
  							divElement.style.visibility="visible";
  							divElement.style.left = x +"px";
  							divElement.style.top = y+"px";
  							
							document.getElementsByTagName("span")[0].innerHTML=id;
							document.getElementsByTagName("span")[1].innerHTML=name;
							document.getElementsByTagName("span")[2].innerHTML=author;
						}
					}
				}  				
  				xhr.open("get","/day32/ImageServlet?time="+new Date().getTime()+"&id="+id);
  				xhr.send(null);
  			} 
  		}
  		function createXHR(){
  			var xhr = null;
  			try{
  				xhr = new ActiveXObject("microsoft.xmlhttp");
  			}catch(e){
				xhr = new XMLHttpRequest();  			
  			}
  			return xhr;
  		}
  	</script>
  </body>
</html>
