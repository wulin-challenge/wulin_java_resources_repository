function dragWindows(){
	 var IsMousedown, LEFT, TOP, login; 
	 document.getElementById("Mdown").onmousedown=function(e) { 
		  login = document.getElementById("loginBox"); 
		  IsMousedown = true; 
		  ee = e||event; 
		  LEFT = e.clientX - parseInt(login.style.left); 
		  TOP = e.clientY - parseInt(login.style.top); 
		  document.onmousemove = function(e) { 
		  ee = e||event; 
		   if (IsMousedown) { 
				login.style.left = e.clientX - LEFT + "px"; 
				login.style.top = e.clientY - TOP + "px"; 
		   } 
		  } 
		  document.onmouseup=function(){ 
			IsMousedown=false; 
		  } 
	 } 
 }
 
 function getFormValue(){
	var username = document.getElementById("username");
	alert(username.value);
 }
